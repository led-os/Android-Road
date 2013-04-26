package com.ty.example_unit_3.libgdx.loadmode;

import java.util.Arrays;
import java.util.Calendar;

import android.util.Log;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.loaders.ModelLoaderRegistry;
import com.badlogic.gdx.graphics.g3d.model.still.StillModel;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Matrix4;
import com.ty.util.DemoWapper;

public class EdgeDetectionTest extends DemoWapper {

	FPSLogger logger;
	ShaderProgram shader;
	StillModel mesh;
	FrameBuffer fbo;
	PerspectiveCamera cam;
	Matrix4 matrix = new Matrix4();
	float angle = 0;
	TextureRegion fboRegion;
	SpriteBatch batch;
	ShaderProgram batchShader;

	float[] filter = {0, 0.25f, 0, 0.25f, -1f, 0.6f, 0, 0.25f, 0,};
	float[] offsets = new float[18];
	
	Texture texture;
	
	long start  = 0;
	int index = 0;

	public void create () {
		
		texture = new Texture(Gdx.files.internal("data/unit3/gd.png"));
		texture.setFilter(TextureFilter.MipMap, TextureFilter.Linear);
		
		ShaderProgram.pedantic = false;
		shader = new ShaderProgram(Gdx.files.internal("data/shaders/default.vert").readString(), Gdx.files.internal(
			"data/shaders/depthtocolor.frag").readString());
		if (!shader.isCompiled()) {
			Gdx.app.log("EdgeDetectionTest", "couldn't compile scene shader: " + shader.getLog());
		}
		batchShader = new ShaderProgram(Gdx.files.internal("data/shaders/batch.vert").readString(), Gdx.files.internal(
			"data/shaders/convolution.frag").readString());
		if (!batchShader.isCompiled()) {
			Gdx.app.log("EdgeDetectionTest", "couldn't compile post-processing shader: " + batchShader.getLog());
		}

		mesh =  ModelLoaderRegistry.loadStillModel(Gdx.files.internal("data/unit3/model/gd.obj"));
		
		fbo = new FrameBuffer(Format.RGB565, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
		cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.position.set(0, 0, 0);
		cam.lookAt(0, 0, -1);
		cam.far = 30;
		batch = new SpriteBatch();
		batch.setShader(batchShader);
		fboRegion = new TextureRegion(fbo.getColorBufferTexture());
		fboRegion.flip(false, true);
		logger = new FPSLogger();
//		calculateOffsets();
	}

	@Override
	public void dispose () {
		shader.dispose();
		batchShader.dispose();
		mesh.dispose();
		fbo.dispose();
		batch.dispose();
	}

	private void calculateOffsets () {
		int idx = 0;
		for (int y = -1; y <= 1; y++) {
			for (int x = -1; x <= 1; x++) {
				offsets[idx++] = x / (float)Gdx.graphics.getWidth();
				offsets[idx++] = y / (float)Gdx.graphics.getHeight();
			}
		}
		System.out.println(Arrays.toString(offsets));
	}

	public void render () {
		
		if(index == 0){
			start = Calendar.getInstance().getTimeInMillis();
		}
		index ++;
		if(Calendar.getInstance().getTimeInMillis() - start > 1000){
			
			Log.i("tyler.tang","FPS:\t"+index);
			index  = 0;
		}
		
		
		angle += 45 * Gdx.graphics.getDeltaTime();
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

		cam.update();
//		matrix.setToRotation(0, 1, 0, angle);
		cam.combined.mul(matrix);

		fbo.begin();
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		Gdx.gl.glEnable(GL20.GL_DEPTH_TEST);
		shader.begin();
		shader.setUniformMatrix("u_projView", cam.combined);
		shader.setUniformf("u_far", cam.far);
		mesh.render(shader);
		shader.end();
		fbo.end();

		texture.bind();
		
		batch.begin();
		batch.disableBlending();
		batchShader.setUniformi("u_filterSize", filter.length);
		batchShader.setUniform1fv("u_filter", filter, 0, filter.length);
		batchShader.setUniform2fv("u_offsets", offsets, 0, offsets.length);
		batch.draw(fboRegion, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();
		logger.log();
	}}