uniform mat4 uMVPMatrix; //�ܱ任����

attribute vec3 aPosition;  //����λ��
attribute vec2 aTexCoor;    //������������
attribute vec3 aNormal;    //���㷨����


varying vec2 vTextureCoord;  //���ڴ��ݸ�ƬԪ��ɫ���ı���
void main()     
{                            		
   gl_Position = uMVPMatrix * vec4(aPosition,1); //�����ܱ任�������˴λ��ƴ˶���λ��
   vTextureCoord = aTexCoor;//�����յ��������괫�ݸ�ƬԪ��ɫ��
}                      
