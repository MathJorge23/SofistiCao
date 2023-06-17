package viwe.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimitaCaracteres extends PlainDocument{
    
    public enum TipoEntrada {
        NUMEROINTEIRO,  NUMERODECIMAL, LETRAS, DATA, EMAIL, TELEFONE, CPF;
    }
    
    private int qtdCaracteres;
    private TipoEntrada tpEntrada;

    public LimitaCaracteres(int qtdCaracteres, TipoEntrada tpEntrada) {
        this.qtdCaracteres = qtdCaracteres;
        this.tpEntrada = tpEntrada;
    }

    @Override
    public void insertString(int i, String str, AttributeSet as) throws BadLocationException {
        if (str == null || getLength() == qtdCaracteres){
            return;
        }
        
        int totalCarac = getLength() + str.length();
        
        // filtros de ecaracteres
       String regex = "";
       
        switch (tpEntrada){
            case NUMEROINTEIRO: regex = "[^0-9]"; break;
            case NUMERODECIMAL: regex = "[^0-9,.]";break;
            case LETRAS: regex = "[^\\p{IsLatin} ]"; break;
            case EMAIL: regex = "[^\\p{IsLatin}@.\\-_][^0-9]"; break;
            case DATA: regex = "[^0-9/]"; break;
            case TELEFONE : regex = "[^0-9()]"; break;
            case CPF: regex = "[^0-9]"; break;
        }
        
        // fazendo substituição
        str  = str.replaceAll(regex, "");
        
        if (totalCarac<= qtdCaracteres){
          super.insertString(i, str, as);  
        }
        else {
            String nova = str.substring(0, qtdCaracteres);
            
        }
         }
    
    
} 
