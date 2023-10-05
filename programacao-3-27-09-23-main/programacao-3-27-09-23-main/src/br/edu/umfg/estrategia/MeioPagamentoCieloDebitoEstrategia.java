package br.edu.umfg.estrategia;

import java.util.Calendar;

public class MeioPagamentoCieloDebitoEstrategia extends MeioPagamentoCieloEstrategia{
    Calendar calendario = Calendar.getInstance();

    public MeioPagamentoCieloDebitoEstrategia(String numeroCartao, String cpf, String cvv, String dataValidade) throws Exception {
        super(numeroCartao, cpf, cvv, dataValidade);
        setNumeroCartao(numeroCartao); // Chama o setter para validar o número do cartão
        setCvv(cvv); // Chama o setter para validar o numero do cvv
        setCpf(cpf); // Chama o setter para validar o cpf
        setDataValidade(dataValidade); // Chama o setter para validadr a data de validade
    }
    
    @Override
    public void pagar(Double valor) {
        System.out.printf("Pagamento via Cielo Debito no valor: " +
                valor + ", realizado com sucesso \n");
    }
    public void setNumeroCartao(String numeroCartao) throws Exception{
        if (numeroCartao.matches("[0-9]*") && numeroCartao.length() == 16){   
            this.numeroCartao = numeroCartao;   
        } else {
            throw new Exception("O cartao deve conter 16 numeros");
        }
    }

    public void setCvv(String cvv) throws Exception{
        if(cvv.matches("[0-9]*") && cvv.length() == 3){
            this.cvv = cvv;
        } else {
            throw new Exception("O cvv deve conter 3 digitos");
        }
    }

    public void setDataValidade(String dataValidade) throws Exception{
        Integer anoAtual = calendario.get(Calendar.YEAR);
        Integer mesAtual = calendario.get(Calendar.MONTH) + 1;
        Integer mes = Integer.parseInt(dataValidade.substring(0, 2));
        Integer ano = Integer.parseInt(dataValidade.substring(3, 5)) + 2000;
        if (ano > anoAtual){
            this.dataValidade = dataValidade;
        } else if (ano == anoAtual || mes >= mesAtual){
            this.dataValidade = dataValidade;
        } else {
            throw new Exception("Validade inferior a atual");
        }
    }

    public void setCpf(String cpf) throws Exception{
        if (cpf.matches("[0-9]*") && cpf.length() == 11){
            if (validaCpf(cpf)){
                this.cpf = cpf;
            } else{
                throw new Exception("CPF INVALIDO");
            }
        } else {
            throw new Exception("O cpf deve conter 11 numeros");
        }
    }

    private Boolean validaCpf(String cpf) throws Exception{
        char num1, num2, num3, num4, num5, num6, num7, num8, num9, num10, num11;
        int int1, int2, int3, int4, int5, int6, int7, int8, int9, int10, int11;
        num1 = cpf.charAt(0);
        num2 = cpf.charAt(1);
        num3 = cpf.charAt(2);
        num4 = cpf.charAt(3);
        num5 = cpf.charAt(4);
        num6 = cpf.charAt(5);
        num7 = cpf.charAt(6);
        num8 = cpf.charAt(7);
        num9 = cpf.charAt(8);
        num10 = cpf.charAt(9);
        num11 = cpf.charAt(10);
        //Pega o valor de cada numero da String cpf
        
        int1 = Integer.parseInt(String.valueOf(num1));
        int2 = Integer.parseInt(String.valueOf(num2));
        int3 = Integer.parseInt(String.valueOf(num3));
        int4 = Integer.parseInt(String.valueOf(num4));
        int5 = Integer.parseInt(String.valueOf(num5));
        int6 = Integer.parseInt(String.valueOf(num6));
        int7 = Integer.parseInt(String.valueOf(num7));
        int8 = Integer.parseInt(String.valueOf(num8));
        int9 = Integer.parseInt(String.valueOf(num9));
        int10 = Integer.parseInt(String.valueOf(num10));
        int11 = Integer.parseInt(String.valueOf(num11));
        //Transforma eles em numeros

        Integer soma1 = (int1 * 10) + (int2 * 9) + (int3 * 8) + (int4  * 7) + (int5 * 6) + (int6 * 5) + (int7 * 4) + (int8 * 3) + (int9 * 2);
        Integer resto1 = (soma1 * 10) % 11;
        //Calcula o primeiro digito verificador
        
        if (resto1 == 10){
            resto1 = 0;
        }
        //Se o resto for 10, entendemos como 0 o valor do verificador

        Integer soma2 = (int1 * 11) + (int2 * 10) + (int3 * 9) + (int4  * 8) + (int5 * 7) + (int6 * 6) + (int7 * 5) + (int8 * 4) + (int9 * 3) + (int10 * 2);
        Integer resto2 = (soma2 * 10) % 11;
         //Calcula o segundo digito verificador

        if (resto2 == 10){
            resto2 = 0;
        }
        //Se o resto for 10, entendemos como 0 o valor do verificador

        if (resto1 == int10 && resto2 == int11){
            return true;
        } else {
            return false;
        }
        //Verifica se os digitos verificadores coincidem
    }


    
}