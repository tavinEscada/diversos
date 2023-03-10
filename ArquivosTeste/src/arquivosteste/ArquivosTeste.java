package arquivosteste;

import java.io.File;
import java.util.Scanner;
import java.util.Vector;

public class ArquivosTeste {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Informe nome do arquivo: ");
        String consulta = entrada.nextLine();
        
        Vector<File> tarefas = new Vector<>();
        tarefas.add(new File("C:\\"));
        while(!tarefas.isEmpty()){
            File arquivoAtual = tarefas.remove(0);
            
            if(arquivoAtual.isFile()){
                
                if(arquivoAtual.getAbsolutePath().contains(consulta)){
                    System.out.println(arquivoAtual.getAbsolutePath());
                }
                
            }else{
                File conteudo[] = arquivoAtual.listFiles();
                
                if(conteudo != null){
                    for(int i = 0; i < conteudo.length; i++){
                        tarefas.add(conteudo[i]);
                    }
                }
            }
        } 
    }   
}
