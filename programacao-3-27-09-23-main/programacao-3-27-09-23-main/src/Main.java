import br.edu.umfg.estrategia.Carrinho;
import br.edu.umfg.estrategia.MeioPagamentoCieloCreditoEstrategia;
import br.edu.umfg.estrategia.MeioPagamentoCieloDebitoEstrategia;
import br.edu.umfg.estrategia.MeioPagamentoDinheiroEstrategia;
import br.edu.umfg.estrategia.Produto;
public class Main {
    public static void main(String[] args) throws Exception {
        Produto produto1 = new Produto("0001",
                "Cola cola 350ml",3.59);
        Produto produto2 = new Produto("0002",
                "X-salada",15.99);
        Carrinho carrinho = new Carrinho();

        carrinho.adicionarProduto(produto1);
        carrinho.adicionarProduto(produto2);

        carrinho.pagar(new MeioPagamentoCieloDebitoEstrategia("1234567123456786", "12203063980", "123", "07/24"));
        carrinho.pagar(new MeioPagamentoCieloCreditoEstrategia("1234567123456786", "12203063980", "123", "09/25"));

       carrinho.pagar(new MeioPagamentoDinheiroEstrategia());
   }
}