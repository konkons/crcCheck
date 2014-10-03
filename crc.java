
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;
import javax.swing.JFileChooser;



/*
 
 Κωνσταντινίδης Κωνσταντίνος Ε08076
  
 */
public class NewJFrame extends javax.swing.JFrame {//NewJFrame υποκλάση της JFrame

    
    public NewJFrame() {
        initComponents();//o constructor καλεί την initComponents() που αρχικοποιεί το παράθυρο
    }

    
                            
    private void initComponents() {//αρχικοποιεί το παράθυρο τις μεταβλητες των διαφόρων αντκειμένων
//swing του παραθύρου,και τοποθετεί event listeners στα κουμπια του παραθύρου
        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel1.setText("Πρόγραμμα υλοποίησης τεχνικής crc ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Αρχείο Κειμένου :");

        jButton1.setText("Αναζήτηση");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setText("Έλεγχος κωδικοποιημένου αρχείου :");

        jButton2.setText("Αναζήτηση");
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) { //όταν ο χρήστης πατά το κουμπί της αναζήτησης αρχείου                                         
       int returnVal = jFileChooser1.showOpenDialog(this);//για έλεγχο κωδικοποιημένου αρχείου κειμένου
if (returnVal == JFileChooser.APPROVE_OPTION) {//ανοίγει το αντικείμενο jFileChooser1 για επιλογή του αρχείου
        File file = jFileChooser1.getSelectedFile();//δημιουργείται το αντικείμενο  τύπου file(κλασης file) που δείχνει στο αρχείο
       String path=file.getAbsolutePath();//αποθηκεύεται η διαδρομή του αρχείου στην path
        elehos(path);}//καλείται η μέθοδος elehos
    }                                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { //όταν ο χρήστης πατά το κουμπί της αναζήτησης αρχείου                                        
int returnVal = jFileChooser1.showOpenDialog(this);//για κωδικοποίηση κειμένου
if (returnVal == JFileChooser.APPROVE_OPTION) {//ανοίγει το αντικείμενο jFileChooser1 για επιλογή του αρχείου
        File file = jFileChooser1.getSelectedFile();//δημιουργείται το αντικείμενο  τύπου file(κλασης file) που δείχνει στο αρχείο
       String path=file.getAbsolutePath();//αποθηκεύεται η διαδρομή του αρχείου στην path
        anagnosi(path);//καλείται η μέθοδος anagnosi
        jLabel4.setText("Δημιουργήθηκε το κωδικοποιημένο αρχείο out.txt");//εμφανίζεται κατάλληλο μήνυμα στο παράθυρο της εφαρμογής
}



    }                                        

  private void  elehos(String path)
   {

    File file = new File(path);//δημιουργείται το αντικείμενο τύπου file(κλασης file) που δείχνει στο αρχείο


    try{

    Scanner input = new Scanner(file);//νεο αντικείμενο input κλάσης scanner 
     int falsecount=0;//αριθμός λανθασμένων κωδικών λέξεων
     int totaltokens=0;//αριθμός κωδικών λέξεων
  while(input.hasNext()) {//για κάθε λέξη του αρχείου 
String nextToken = input.next();//τα tokens έχουν by default delimiter το κενό

if(!check(nextToken))//καλεσμα της check για κάθε λέξη του κειμένου
{
falsecount=falsecount+1;
}

 totaltokens=totaltokens+1;

}
float percentage=(float)falsecount/totaltokens*100;
 jLabel4.setText("Βρέθηκαν "+falsecount+" λάθη.Ποσοστό:"+percentage+"%");//εμφάνιση στατιστικών

    }
   catch(IOException e)
   { }
 


    }
    private void anagnosi(String path)
   {
    Writer output = null;
    File file = new File(path);
    File fileout = new File("out.txt");//δημιουργία του out.txt

    
    try{
       
    Scanner input = new Scanner(file);
        output = new BufferedWriter(new FileWriter(fileout));
  while(input.hasNext()) { 
String nextToken = input.next();


    
    output.write(crcgen(wordconv(nextToken)));//εγγραφή στο out.txt της crc κωδικής λέξης καλεσμα της wordconv και crcgen για κάθε λέξη του κειμένου
    output.write(" ");//κάθε κωδικοποιημένη λέξη χωρίζεται με κενό
    
}



    output.close();}//κλείσιμο αρχείου out.txt
   catch(IOException e)
   { }
   

    
    }
 private String wordconv(String x)//μετατροπή μιας λέξης σε κωδική λέξη με χρήση της δυαδικής μορφής των χαρακτήρων ASCII
    {
        char[] word= x.toCharArray();//μετατροπή της λέξης (string) σε char array
        int l;//βοηθητική μεταβλητή όπου αποθηκεύεται προσωρινά η δεκαδική μορφή του κάθε ASCII χαρακτήρα
        String result="";//String όπου θα αποθηκευτούν όλα τα ASCII γράμματα της λέξης σε δυαδική μορφή δημιουργώντας την κωδικολέξη
         for (int i = 0; i < word.length; i++) {//βρόχος για την μετατροπή κάθε γράμματος σε δεκαδική και έπειτα
		 //σε δυαδική ASCII μορφή

           l=(int) word[i];
           result=result+Integer.toBinaryString(l);//το String όπου περιέχει σε δυαδική ASCII μορφή κάθε γράμμα της λέξης 

        }


        return result;//επιστρέφει την κωδική λέξη 
    }
private String crcgen(String x)//μέθοδος για την εφαρμογή της τεχνικής crc στην κωδική λέξη
    {


      String divisor="100000100110000010001110110110111";//ο διαιρέτης που πρέρχεται απο το παράγον πολυώνυμο 
      for(int i=0;i<divisor.length()-1;i++)
      {
          x=x+"0";//σύμφωνα με τον αλγόριθμο crc προσθέτω στο τέλος της κωδικής λέξης μηδενικά
//όσα η δύναμη του παράγοντα πολυωνύμου (32)  
        }


       char[] remainder=x.toCharArray();//μετατροπή κωδικής λέξης σε char Array για εύκολη χρήση κάθε ψηφίου
       char[] d=divisor.toCharArray();//μετατροπή divisor σε char Array για εύκολη χρήση κάθε ψηφίου
       boolean codition=true;//μεταβλητή ελέγχου.Χρησιμοποιήται για να σηματοδοτήσει το τέλος της crc διαίρεσης

//ο αλγόριθμος που ακολουθείται για την διαίρεση είναι ο εξής:
//Αν το πιο αριστερό ψηφίο του διαιρεταίου είναι 0 ολίσθησε τον διαιρέτη ένα bit δεξιά(xor με μηδενικά)
//Αν το πιο αριστερό ψηφίο του διαιρεταίου είναι 1 κάνε xor κάθε ψηφίο του διαιρέτη με το αντίστοιχο του διαιρεταίου
//ο διαιρέτης τότε ολισθαίνει 1 bit δεξιά.Η διαδικασία επαναλαμβάνεται μέχρι ο διαιρέτης να φτάσει το δεξιό άκρο
//του διαιρεταίου
/*
παράδειγμα διαίρεσης
11010011101100 <--- διαιρεταίος
1011           <--- διαιρέτης
01100011101100 <--- αποτέλεσμα
 1011          <--- διαιρέτης
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
00000000000101 <---υπόλοιπο



*/






       while(codition)
       {

           for(int i=0;i<remainder.length;i++)//βρόγχος προσπέλασης κάθε ψηφίου του διαιρεταίου από τα αριστερά προς τα δεξιά
           {

               if (remainder[i]=='1')//Εύρεση του πρώτου 1 από τα αριστερά
			   //(αν συναντάμε 0 ουσιαστικά γίνεται ολίσθηση προς τα δεξιά του διαιρέτη)
               {
                  for(int j=0;j<d.length;j++)//για κάθε ψηφίο του διαιρέτη xor με το απο πάνω του διαιρεταίου
                  {


                      if(remainder[i]==d[j])//αν τα ψηφία ίδια το αποτέλεσμα 0
                      {remainder[i]='0';}
                      else {remainder[i]='1';}//αν διαφορετικά 1 το αποτέλεσμα (xor)


                      i=i+1;//επόμενο ψηφίο του διαιρεταίου προς τα δεξιά μέχρι να τελιώσει η πράξη xor
                      //δηλαδη μέχρι να τελιώσουν τα ψηφία του διαιρέτη (divisor)					  


                    }

                    break;//έξοδος από τον πρώτο βρόγχο γιά έλεγχο τέλους διαίρεσης και επαναπρσπέλασης 
					//του αποτελέσματος της διαίρεσης απο αριστερά προς τα δεξιά

                }






            }



           for(int i=0;i<remainder.length;i++)//έλεγχος τέλους(αν έφτασε στο πιο δεξί άκρο του διαιρεταίου ο διαιρέτης)
           {
               if (remainder[i]=='1')//βρίσκουμε το πρώτο 1 στο αποτέλεσμα
               {   if (remainder.length-i>=d.length)//Αν απέχει απο το δεξί άκρο πιο πολλά ψηφία απο το πλήθος των 
                   {break;}//ψηφίων του διαιρέτη ή όσο είναι το πλήθος των ψηφίων του τότε συνεχίζουμε την διαιρεση
                        //εξοδος από τον βρόγχο


                   if(remainder.length-i<d.length)//Αν απέχει απο το δεξί άκρο πιο λίγα ψηφία απο το πλήθος των
                     {//ψηφίων του διαιρέτη

                         codition=false;//flag διαίρεσης false έξοδος από τον βρόγχο

                     break;}

               }


            }


        }


      char[] crc=x.toCharArray();
      for(int i=0;i<32;i++)//προσθέτουμε το υπόλοιπο το οποίο δεν μπορει έχει περισσοτερα ψηφία απο τα μηδενικά που προσθέσαμε στο τέλος
//του διαιρεταίου	  
      {crc[crc.length-i-1]=remainder[crc.length-i-1];}//αντιγράφουμε το υπόλοιπο απο τα δεξιά προς τα αριστερά μέχρι να καλύψουμε
	  //όλα τα μηδενικά του τέλους (32 bit)
     x="";
      for(int i=0;i<crc.length;i++)
      {x=x+crc[i];}//μετατροπή της crc κωδικής λέξης σε string






    return x;
    }

 private boolean check(String y)//έλεγχος αν ένα string που περιέχει την crc κωδική λέξη έχει σφάλμα
 //κάνουμε ξανά διαίρεση (όπως στην crcgen()) της crc κωδικής λέξης με τον διαιρέτη και 
 //θέλουμε το υπόλοιπο να είναι 0 για να μην υπάρχει λάθος
    {

        String divisor="100000100110000010001110110110111";

        char[] remainder=y.toCharArray();
       char[] d=divisor.toCharArray();
       boolean codition=true;

     boolean result=true;//ελέγχει αν η διαίρεση έχει υπόλοιπο 0
       while(codition)
       {


           for(int i=0;i<remainder.length;i++)//ξεκινάμε απο τον έλεγχο της διαίρεσης 
		   
           {

                for(int p=0;p<remainder.length;p++)
        { if(remainder[p]=='1')//αν βρουμε 1 συνεχίζουμε τον έλεγχο
            {result=false;//και η διαίρεση δεν είναι τέλεια

                break;}
                else result=true;//αν υπόλοιπο 0 τότε σταματάμε την διαίρεση και ο crc έλεγχος είναι αληθής(τέλεια διαίρεση)
            }
               if(result==true)
            {codition=false;
                break;}




               if (remainder[i]=='1')
               {   if (remainder.length-i>=d.length)//αν το 1 που βρήκαμε δεν βρίσκεται στο υπόλοιπο 
                   {break;}//και άρα μπορούμε να συνεχίσουμε την διαίρεση συνεχίζουμε την διαίρεση



                   if(remainder.length-i<d.length)//αν το 1 που βρήκαμε είναι στο υπόλοιπο τότε τερματίζεται η διαίρεση
                     {

                         codition=false;

                     break;}

               }
            }


           if(codition==false)
            {
                break;}



           for(int i=0;i<remainder.length;i++)//η διαίρεση (xor)
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
            else return false;//επιστρέφουμε το flag του αν η διαίρεση είναι τέλεια




    }






    public static void main(String args[]) {//η main μέθοδος της εφαρμογής απο εδώ ξεκινά το πρόγραμμα
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {//δημιουργία thread για την κλάσση jFrame
                new NewJFrame().setVisible(true);//εμφάνιση του παραθύρου swing και κλήση του constructor
            }
        });
    }

          //δήλωση των swing  μεταβλητών της κλασσης jframe (τα αντικείμενα του παραθύρου της εφαρμογής)       
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
                      

}
