import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex1{
    public static void main(String[] args){
        String texto = "Meu e-mail é alexya@gomes.com";
        Pattern pattern = Pattern.compile("\\w+@\\w+.\\w+");
        Matcher matcher = pattern.matcher(texto);
        if(matcher.find()){
            System.out.println(matcher.group(0));
        }
        String numero = "31984445037";
        Pattern patternNumero = Pattern.compile("\\d+");
        matcher = patternNumero.matcher(numero);
        if (matcher.find()) {
            System.out.println(matcher.group(0));
            numero = matcher.group(0);
        }
        Pattern patterNumeroTelefone = Pattern.compile("(\\d{2})(\\d{4,5})(\\d{4})");
        matcher = patterNumeroTelefone.matcher(numero);
        if(matcher.matches()){
            System.out.println("Matcher Group 2: "+matcher.group());
            String numeroFormatado = String.format("(%s) %s-%s", matcher.group(1),matcher.group(2),matcher.group(3));
            System.out.println(numeroFormatado);
        }
        numero = "(31)94242-2313";
        System.out.println("\nNUMERO 2:"+numero);
        Pattern naoNumero = Pattern.compile("([0-9]{3})");
        matcher = naoNumero.matcher(numero);
        while(matcher.find()){
            System.out.println(matcher.group(0));
        }

        String nomeArquivo = "nome.legal.pdf";
        int posArquivp = nomeArquivo.lastIndexOf(".");
        if(posArquivp!=-1){
            String nomeArquivoSemTipo = nomeArquivo.substring(0, posArquivp);
            System.out.println(nomeArquivoSemTipo);
        }else{
            System.out.println("Sem tipo de arquivo");
        }

    }
}