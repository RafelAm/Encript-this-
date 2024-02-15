import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BasicEncryptTest {
    @Test
    public void testDecrypt() throws Exception {
        BasicEncrypt enc = new BasicEncrypt();
        assertEquals("text = '', rule = 1", "",
                     enc.encrypt("", 1));
        assertEquals("text = 'a', rule = 1", "b",
                     enc.encrypt("a", 1));
        assertEquals("text = 'please encrypt me', rule = 2", "rngcug\"gpet{rv\"og",
                     enc.encrypt("please encrypt me", 2));
    }
}

public class BasicEncrypt {

    public String encrypt(String text, int rule) {
      // Creamos un String para concatenar los valores
      String res = "";
      
      // Si text esta vacío se devuelve vacío
      if(text == ""){
        return res;
      }
      // Bucle para recorrer los caracteres 1 por 1
      for(int i = 0; i < text.length(); i++){
        // Si rule es mayor a 255 le restam os 256
        if(rule > 255){
          rule -= 256;
        }
        // Creamos una variable integer para convertir los caracteres y sumarles la regla 1 por 1
        int ascii = (int) text.charAt(i) + rule;
        // Si ascii es mayor a 255  le restamos 256
        if(ascii > 255){
          ascii -= 256;
        }
        // Concatenamos y convertimos los integers a char para que nos devuelva el caracter
        char c = (char) ascii;
        res += c;
      }
      
      
      
      
      
      
      
      
       return res;
    }
}
