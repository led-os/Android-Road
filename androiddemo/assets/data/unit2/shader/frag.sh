precision mediump float;
uniform sampler2D sTexture;//������������
//���մӶ�����ɫ�������Ĳ���
varying vec2 vTextureCoord;

void main()                         
{    
   //�����������ɫ����ƬԪ
   vec4 finalColor=texture2D(sTexture, vTextureCoord);    
   gl_FragColor = finalColor;
}   
