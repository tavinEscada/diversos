package tprascunho;

import java.util.Vector;

/**
 *
 * @author otavi
 */

public class TpRascunho {

    //método que calcula o dígito verificador 1 a ser comparado - "digito1"
    public static int dV1(Vector<Integer> cpf9){
        
        int multiplicador = 2;
        
        int soma = 0;
        
        //multiplica cada um dos 9 primeiros dígitos por seu multiplicador
        for(int i = 8; i >= 0; i--){
           soma+= cpf9.get(i) * multiplicador;
            multiplicador++;
        }
        
        int digito1 = 0;
        
        //define o dígito verificador 1
        if(soma % 11 < 2){
            digito1 = 0;
        }else{
            if(soma % 11 >= 2){
                digito1 = 11 - (soma % 11);
            }
        }
        
        //retorna o resultado
        return digito1;
    }
    
    //método que calcula o dígito verificador 2 a ser comparado 
    //com o digito do CPF analisado
    public static int dV2(Vector<Integer> cpf10){
        
        int multiplicador = 2;
        
        int soma = 0;
        
        //multiplicando os nove primeiros digitos 
        //E o primeiro dígito verificador por seus multiplicadores
        for(int i = 9; i >= 0; i--){
           soma+= cpf10.get(i) * multiplicador;
            multiplicador++;
        }
        
        int digito2 = 0;
        
        //define o dígito verificador 2
        if(soma % 11 < 2){
            digito2 = 0;
        }else{
            if(soma % 11 >= 2){
                digito2 = 11 - (soma % 11);
            }
        }
        
        //retorna o resultado
        return digito2;
    }
    
    //método que compara os digitos verificadores calculados com os digitos verificadores do CPF analisado
    public static Boolean validacao (Vector<Integer> cpfA){
        
        //vetor auxiliar
        Vector<Integer> cpfB = new Vector<>();
        
        //"copiando" os 9 primeiros digitos do CPF a ser analisado ("cpfA") para "cpfB"
        for(int n = 0; n <= 8; n++){
            cpfB.add(cpfA.get(n));
        }                                        
        
        //adicionando os dígitos verificadores calculados a 'cpfB'
        cpfB.add(dV1(cpfA));
        cpfB.add(dV2(cpfA));
        
        //comparando os dígitos verificadores do 'cpfB' com os digitos verificadores do cpf original ("cpfA"):
        if(cpfA.get(9) == dV1(cpfA) && cpfA.get(10) == dV2(cpfB)){
            //se os digitos verificadores originais são iguais aos calculados, o cpf é valido
            return true;
        
        }else{
            //se não, o cpf não é válido
            return false;
        }
    }
    
    //método que exibe o CPF
    public static void mostraCpf(Vector<Integer> cpf){
        
            //exibindo o CPF, separando os dígitos com "." e "-"
            for(int a = 0; a <=2; a++){
                System.out.print(cpf.get(a));
            }
            System.out.print(".");
            
            for(int a = 3; a <= 5; a++){
                System.out.print(cpf.get(a));
            }
            System.out.print(".");
            
            for(int a = 6; a <= 8; a++){
                System.out.print(cpf.get(a));
            }
            System.out.print("-");
            
            for(int a = 9; a <= 10; a++){
                System.out.print(cpf.get(a));
            }   
            
            //saltando uma linha para o próximo CPF
            System.out.println("");
    }

    
    public static void main(String[] args) {
        
        //vetor onde o CPF a ser analisado será armazenado
        Vector<Integer> cpf = new Vector<>();
        
        //preenchendo os 11 índices do vetor "cpf" com 0s
        for(int i = 0; i <= 10; i++){
            cpf.add(0);
        }
        
        //11 laços de repetição encapsulados;
        //geram todas as possibilidades de CPF
        for(int i = 9; i >= 0; i--){
            cpf.set(0, i);
            for(int a = 9; a >= 0; a--){
                cpf.set(1, a);
                for(int b = 9; b >= 0; b--){
                    cpf.set(2, b);
                    for(int c = 9; c >= 0; c--){
                        cpf.set(3, c);
                        for(int d = 9; d >= 0; d--){
                            cpf.set(4, d);
                            for(int e = 9; e >= 0; e--){
                                cpf.set(5, e);
                                for(int f = 9; f >=0; f--){
                                    cpf.set(6, f);
                                    for(int g = 9; g >= 0; g--){
                                        cpf.set(7, g);
                                        for(int h = 9; h >= 0; h--){
                                            cpf.set(8, h);
                                            for(int j = 9; j >= 0; j--){
                                                cpf.set(9, j);
                                                for(int k = 9; k >= 0; k--){
                                                    cpf.set(10, k);
                                                    
                                                    //se o método validação tiver resultado 
                                                    //verdadeiro, o CPF é exibido
                                                    if(validacao(cpf) == true){
                                                        mostraCpf(cpf);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
    }
    
}
