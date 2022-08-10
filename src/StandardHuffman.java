/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//import static standardhuffman.HuffmanEncoder.test;

/**
 *
 * @author HP
 */
import java.io.*; 
import java.util.*;
public class StandardHuffman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
    	
    	Scanner scan = new Scanner(System.in) ;
    	String path = scan.next(); 
        final String test = readFile(path);
        final HuffmanEncoder encoder=new HuffmanEncoder();
        final HuffmanEncodedResult result=encoder.compress(test);
        System.out.println(result.encodedData);
        System.out.println(encoder.decompress(result));
     
      
        
        
        
        
      }
       
     
        
   public static String readFile(String fileName) throws IOException{
	   
	   // output string
	   String output = ""  ;
	   
	   FileReader file  = new FileReader(fileName) ;
	   BufferedReader br = new BufferedReader(file) ;
	   String line = br.readLine() ;
	   
	   while(line!=null) {
	
		   output+= line ;
		   line = br.readLine();
	   }
	   return output ;
    	
    }
    
}
