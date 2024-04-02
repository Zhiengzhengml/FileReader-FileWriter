import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
public class App {
    public static void main(String[] args) throws Exception {
        String filePath = "C:\\Users\\z\\Downloads\\Groceries.txt";
        String fileTowrite = "C:\\Users\\z\\Downloads\\GroceriesFormatted.txt";
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(fileTowrite);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        //new String(char[],off,len)
        String[] array = new String[4];
        String line;
        String ID;
        String itemName;
        String quantity;
        double price;
        
        //String separator=",";

        double totalPrice=0.0;
        //line=bufferedReader.readLine();
        
        /* System.out.println("********************************************************");
        System.out.println("ID#\titem\t\tQuantity\tPrice(€)."); */
        bufferedWriter.write("***********************************************************");
        bufferedWriter.newLine();
        bufferedWriter.write("ID#"+"\t"+"item"+"\t\t\t"+"Quantity"+"\t\t"+"Price");

       // bufferedWriter.write("ID#\titem\t\tQuantity\t\tPrice(€).");
        bufferedWriter.newLine();
    
        while((line=bufferedReader.readLine())!= null){
           array=line.split(",");
           ID = array[0];
           itemName = array[1];
           quantity = array[2];
           price = Double.parseDouble(array[3]);
           totalPrice += price; 

           if(itemName.length()<5 && quantity.length()<4 ){
            line=ID+"\t"+itemName+"\t\t\t"+quantity+"\t\t\t"+price;
           } else if(itemName.length()>=5 && quantity.length()<4 ) {
            line=ID+"\t"+itemName+"\t\t"+quantity+"\t\t\t"+price;
           }else{
            line=ID+"\t"+itemName+"\t\t"+quantity+"\t\t"+price;
           }
           

      

          

           //bufferedWriter.write(ID+"\t"+itemName+"\t\t"+quantity+"\t\t"+price);
          // line=ID+"\t"+itemName+"\t\t"+quantity+"\t\t"+price;

          System.out.println(line);
          bufferedWriter.write(line);
          bufferedWriter.newLine();
        } 
        
        //System.out.println("********************************************************");   
        System.out.println("The grocey shopping total is: €" + Math.round(totalPrice)); 
        //System.out.println("********************************************************");   
        bufferedWriter.write("***********************************************************");
        bufferedWriter.newLine();
        bufferedWriter.write("The grocey shopping total is: €" + Math.round(totalPrice));
        bufferedWriter.newLine();
        bufferedWriter.write("***********************************************************");
        bufferedWriter.newLine();
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();

    }
}
