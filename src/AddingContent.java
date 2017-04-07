import java.io.File; 
import java.io.IOException;
  
import org.apache.pdfbox.pdmodel.PDDocument; 
import org.apache.pdfbox.pdmodel.PDPage; 
import org.apache.pdfbox.pdmodel.PDPageContentStream; 
import org.apache.pdfbox.pdmodel.font.PDType1Font;
  
public class AddingContent {
   public static void main (String args[]) throws IOException {

      //Loading an existing document
      File file = new File("./files/hello.pdf");
      PDDocument document = PDDocument.load(file);
       
      //Retrieving the pages of the document 
      PDPage page = document.getPage(1);
      PDPageContentStream contentStream = new PDPageContentStream(document, page);
      
      //Begin the Content stream 
      contentStream.beginText(); 
       
      //Setting the font to the Content stream  
      contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);

      //Setting the position for the line 
      contentStream.newLineAtOffset(100, 700); //x en partant de la gauche, y du bas (

      String text = "Yo";

      //Adding text in the form of string 
      contentStream.showText(text);      

      //Ending the content stream
      contentStream.endText();

      System.out.println("Content added");

      //Closing the content stream
      contentStream.close();

      //Saving the document
      document.save(new File("./files/hello.pdf"));

      //Closing the document
      document.close();
   }
}