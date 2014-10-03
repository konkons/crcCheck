
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;
import javax.swing.JFileChooser;



/*
 
 �������������� ������������ �08076
  
 */
public class NewJFrame extends javax.swing.JFrame {//NewJFrame �������� ��� JFrame

    
    public NewJFrame() {
        initComponents();//o constructor ����� ��� initComponents() ��� ����������� �� ��������
    }

    
                            
    private void initComponents() {//����������� �� �������� ��� ���������� ��� �������� �����������
//swing ��� ���������,��� ��������� event listeners ��� ������� ��� ���������
        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel1.setText("��������� ���������� �������� crc ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("������ �������� :");

        jButton1.setText("���������");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setText("������� ��������������� ������� :");

        jButton2.setText("���������");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(jLabel1))
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        pack();
    }                      

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) { //���� � ������� ���� �� ������ ��� ���������� �������                                         
       int returnVal = jFileChooser1.showOpenDialog(this);//��� ������ ��������������� ������� ��������
if (returnVal == JFileChooser.APPROVE_OPTION) {//������� �� ����������� jFileChooser1 ��� ������� ��� �������
        File file = jFileChooser1.getSelectedFile();//������������� �� �����������  ����� file(������ file) ��� ������� ��� ������
       String path=file.getAbsolutePath();//������������ � �������� ��� ������� ���� path
        elehos(path);}//�������� � ������� elehos
    }                                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { //���� � ������� ���� �� ������ ��� ���������� �������                                        
int returnVal = jFileChooser1.showOpenDialog(this);//��� ������������ ��������
if (returnVal == JFileChooser.APPROVE_OPTION) {//������� �� ����������� jFileChooser1 ��� ������� ��� �������
        File file = jFileChooser1.getSelectedFile();//������������� �� �����������  ����� file(������ file) ��� ������� ��� ������
       String path=file.getAbsolutePath();//������������ � �������� ��� ������� ���� path
        anagnosi(path);//�������� � ������� anagnosi
        jLabel4.setText("������������� �� �������������� ������ out.txt");//����������� ��������� ������ ��� �������� ��� ���������
}



    }                                        

  private void  elehos(String path)
   {

    File file = new File(path);//������������� �� ����������� ����� file(������ file) ��� ������� ��� ������


    try{

    Scanner input = new Scanner(file);//��� ����������� input ������ scanner 
     int falsecount=0;//������� ����������� ������� ������
     int totaltokens=0;//������� ������� ������
  while(input.hasNext()) {//��� ���� ���� ��� ������� 
String nextToken = input.next();//�� tokens ����� by default delimiter �� ����

if(!check(nextToken))//������� ��� check ��� ���� ���� ��� ��������
{
falsecount=falsecount+1;
}

 totaltokens=totaltokens+1;

}
float percentage=(float)falsecount/totaltokens*100;
 jLabel4.setText("�������� "+falsecount+" ����.�������:"+percentage+"%");//�������� �����������

    }
   catch(IOException e)
   { }
 


    }
    private void anagnosi(String path)
   {
    Writer output = null;
    File file = new File(path);
    File fileout = new File("out.txt");//���������� ��� out.txt

    
    try{
       
    Scanner input = new Scanner(file);
        output = new BufferedWriter(new FileWriter(fileout));
  while(input.hasNext()) { 
String nextToken = input.next();


    
    output.write(crcgen(wordconv(nextToken)));//������� ��� out.txt ��� crc ������� ����� ������� ��� wordconv ��� crcgen ��� ���� ���� ��� ��������
    output.write(" ");//���� �������������� ���� ��������� �� ����
    
}



    output.close();}//�������� ������� out.txt
   catch(IOException e)
   { }
   

    
    }
 private String wordconv(String x)//��������� ���� ����� �� ������ ���� �� ����� ��� �������� ������ ��� ���������� ASCII
    {
        char[] word= x.toCharArray();//��������� ��� ����� (string) �� char array
        int l;//��������� ��������� ���� ������������ ��������� � �������� ����� ��� ���� ASCII ���������
        String result="";//String ���� �� ������������ ��� �� ASCII �������� ��� ����� �� ������� ����� ������������� ��� ����������
         for (int i = 0; i < word.length; i++) {//������ ��� ��� ��������� ���� ��������� �� �������� ��� ������
		 //�� ������� ASCII �����

           l=(int) word[i];
           result=result+Integer.toBinaryString(l);//�� String ���� �������� �� ������� ASCII ����� ���� ������ ��� ����� 

        }


        return result;//���������� ��� ������ ���� 
    }
private String crcgen(String x)//������� ��� ��� �������� ��� �������� crc ���� ������ ����
    {


      String divisor="100000100110000010001110110110111";//� ��������� ��� ��������� ��� �� ������� ��������� 
      for(int i=0;i<divisor.length()-1;i++)
      {
          x=x+"0";//������� �� ��� ��������� crc �������� ��� ����� ��� ������� ����� ��������
//��� � ������ ��� ��������� ���������� (32)  
        }


       char[] remainder=x.toCharArray();//��������� ������� ����� �� char Array ��� ������ ����� ���� ������
       char[] d=divisor.toCharArray();//��������� divisor �� char Array ��� ������ ����� ���� ������
       boolean codition=true;//��������� �������.�������������� ��� �� ������������� �� ����� ��� crc ���������

//� ���������� ��� ������������ ��� ��� �������� ����� � ����:
//�� �� ��� �������� ����� ��� ����������� ����� 0 �������� ��� �������� ��� bit �����(xor �� ��������)
//�� �� ��� �������� ����� ��� ����������� ����� 1 ���� xor ���� ����� ��� �������� �� �� ���������� ��� �����������
//� ��������� ���� ���������� 1 bit �����.� ���������� ��������������� ����� � ��������� �� ������ �� ����� ����
//��� �����������
/*
���������� ���������
11010011101100 <--- �����������
1011           <--- ���������
01100011101100 <--- ����������
 1011          <--- ���������
00111011101100
  1011
00010111101100
   1011
00000001101100
       1011
00000000110100
        1011
00000000011000
         1011
00000000001110
          1011
--------------
00000000000101 <---��������



*/






       while(codition)
       {

           for(int i=0;i<remainder.length;i++)//������� ����������� ���� ������ ��� ����������� ��� �� �������� ���� �� �����
           {

               if (remainder[i]=='1')//������ ��� ������ 1 ��� �� ��������
			   //(�� ��������� 0 ���������� ������� �������� ���� �� ����� ��� ��������)
               {
                  for(int j=0;j<d.length;j++)//��� ���� ����� ��� �������� xor �� �� ��� ���� ��� �����������
                  {


                      if(remainder[i]==d[j])//�� �� ����� ���� �� ���������� 0
                      {remainder[i]='0';}
                      else {remainder[i]='1';}//�� ����������� 1 �� ���������� (xor)


                      i=i+1;//������� ����� ��� ����������� ���� �� ����� ����� �� �������� � ����� xor
                      //������ ����� �� ��������� �� ����� ��� �������� (divisor)					  


                    }

                    break;//������ ��� ��� ����� ������ ��� ������ ������ ��������� ��� ��������������� 
					//��� ������������� ��� ��������� ��� �������� ���� �� �����

                }






            }



           for(int i=0;i<remainder.length;i++)//������� ������(�� ������ ��� ��� ���� ���� ��� ����������� � ���������)
           {
               if (remainder[i]=='1')//��������� �� ����� 1 ��� ����������
               {   if (remainder.length-i>=d.length)//�� ������ ��� �� ���� ���� ��� ����� ����� ��� �� ������ ��� 
                   {break;}//������ ��� �������� � ��� ����� �� ������ ��� ������ ��� ���� ����������� ��� ��������
                        //������ ��� ��� ������


                   if(remainder.length-i<d.length)//�� ������ ��� �� ���� ���� ��� ���� ����� ��� �� ������ ���
                     {//������ ��� ��������

                         codition=false;//flag ��������� false ������ ��� ��� ������

                     break;}

               }


            }


        }


      char[] crc=x.toCharArray();
      for(int i=0;i<32;i++)//����������� �� �������� �� ����� ��� ������ ���� ����������� ����� ��� �� �������� ��� ���������� ��� �����
//��� �����������	  
      {crc[crc.length-i-1]=remainder[crc.length-i-1];}//������������ �� �������� ��� �� ����� ���� �� �������� ����� �� ���������
	  //��� �� �������� ��� ������ (32 bit)
     x="";
      for(int i=0;i<crc.length;i++)
      {x=x+crc[i];}//��������� ��� crc ������� ����� �� string






    return x;
    }

 private boolean check(String y)//������� �� ��� string ��� �������� ��� crc ������ ���� ���� ������
 //������� ���� �������� (���� ���� crcgen()) ��� crc ������� ����� �� ��� �������� ��� 
 //������� �� �������� �� ����� 0 ��� �� ��� ������� �����
    {

        String divisor="100000100110000010001110110110111";

        char[] remainder=y.toCharArray();
       char[] d=divisor.toCharArray();
       boolean codition=true;

     boolean result=true;//������� �� � �������� ���� �������� 0
       while(codition)
       {


           for(int i=0;i<remainder.length;i++)//�������� ��� ��� ������ ��� ��������� 
		   
           {

                for(int p=0;p<remainder.length;p++)
        { if(remainder[p]=='1')//�� ������ 1 ����������� ��� ������
            {result=false;//��� � �������� ��� ����� ������

                break;}
                else result=true;//�� �������� 0 ���� ��������� ��� �������� ��� � crc ������� ����� ������(������ ��������)
            }
               if(result==true)
            {codition=false;
                break;}




               if (remainder[i]=='1')
               {   if (remainder.length-i>=d.length)//�� �� 1 ��� ������� ��� ��������� ��� �������� 
                   {break;}//��� ��� �������� �� ����������� ��� �������� ����������� ��� ��������



                   if(remainder.length-i<d.length)//�� �� 1 ��� ������� ����� ��� �������� ���� ������������ � ��������
                     {

                         codition=false;

                     break;}

               }
            }


           if(codition==false)
            {
                break;}



           for(int i=0;i<remainder.length;i++)//� �������� (xor)
           {

               if (remainder[i]=='1')
               {
                  for(int j=0;j<d.length;j++)
                  {


                      if(remainder[i]==d[j])
                      {remainder[i]='0';}
                      else {remainder[i]='1';}


                      i=i+1;


                    }

                    break;

                }






            }





        }



            if (result==true)
            return result;
            else return false;//������������ �� flag ��� �� � �������� ����� ������




    }






    public static void main(String args[]) {//� main ������� ��� ��������� ��� ��� ������ �� ���������
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {//���������� thread ��� ��� ������ jFrame
                new NewJFrame().setVisible(true);//�������� ��� ��������� swing ��� ����� ��� constructor
            }
        });
    }

          //������ ��� swing  ���������� ��� ������� jframe (�� ����������� ��� ��������� ��� ���������)       
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
                      

}
