package controle;
import javax.swing.text.*;

public class InputFilter extends DocumentFilter {
    public static final int SOMENTE_LETRAS = 1;
    public static final int SOMENTE_NUMEROS = 2;

    private int tipo;

    public InputFilter(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (verificar(string)) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String string, AttributeSet attr) throws BadLocationException {
        if (verificar(string)) {
            super.replace(fb, offset, length, string, attr);
        }
    }

    private boolean verificar(String texto) {
    	if (texto == null || texto.isEmpty()) return true;

        switch (tipo) {
            case SOMENTE_LETRAS:
            	return texto.matches("[a-zA-Z ]+");
            case SOMENTE_NUMEROS:
            	return texto.matches("[\\d ]+");
            default:
                return true;
        }
    }
}
