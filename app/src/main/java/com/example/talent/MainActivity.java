package com.example.talent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    SearchView searchView;
    CustomAdepter customAdepter;

    ArrayList<CustomModel> customModelArrayList = new ArrayList<>();

    private Button bottom_perfil;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);
        searchView = findViewById(R.id.searchView);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        getSupportActionBar().hide();


        itemDisplay();


        IniciarComponentes();

        bottom_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.talent.MainActivity.this,PerfilActivity.class);
                startActivity(intent);
            }
        });






        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                filter(newText);

                return true;



            }
        });





    }

    private void filter(String newText) {

        ArrayList<CustomModel> filtereadList = new ArrayList<>();

        for (CustomModel item :customModelArrayList){

            if (item.getTitle().toLowerCase().contains(newText.toLowerCase())){

                filtereadList.add(item);


            }

            customAdepter.filterList(filtereadList);

        }






    }

    private void itemDisplay(){

        customModelArrayList.add(new CustomModel(R.drawable.homem,"Marcos Lima  Vendedor","Experiência\n" +
                "Marcos Lima possui 15 anos de experiência em vendas, com foco em produtos eletrônicos e tecnologia de consumo.\n" +
                "\n" +
                "Problema: Durante uma campanha promocional, a loja em que Marcos trabalhava enfrentou uma concorrência acirrada, resultando em uma queda nas vendas. Muitos clientes estavam sendo atraídos por ofertas de concorrentes, e a equipe de vendas estava lutando para atingir suas metas.\n" +
                "Solução: Marcos sugeriu e implementou um programa de fidelidade, oferecendo incentivos como descontos adicionais e brindes exclusivos para clientes recorrentes. Ele também treinou a equipe de vendas para destacar os diferenciais dos produtos e o valor agregado das ofertas da loja. Além disso, Marcos organizou eventos de demonstração de produtos que atraíram novos clientes e incentivaram as compras. Essas ações resultaram em um aumento de 20% nas vendas durante o período promocional e ajudaram a loja a recuperar sua posição no mercado."));
        customModelArrayList.add(new CustomModel(R.drawable.homem2,"Joao Desenvolvedor de Software","Experiência\n" +
                "João Silva foi responsável por liderar a migração de uma aplicação monolítica para uma arquitetura de microsserviços na TechCorp.\n" +
                "Problema: A aplicação monolítica da empresa, que era essencial para as operações de e-commerce, começou a apresentar problemas graves de desempenho. Durante picos de tráfego, especialmente em períodos promocionais, a aplicação ficava extremamente lenta, resultando em tempos de resposta elevados e, em alguns casos, em falhas completas do sistema. Isso causava frustração entre os usuários, alta taxa de abandono de carrinho, e, consequentemente, perda de receita.\n" +
                "Solução: João identificou que o principal problema era a estrutura monolítica da aplicação, onde todos os processos eram interdependentes, o que tornava o sistema inflexível e difícil de escalar. Ele propôs a migração para uma arquitetura de microsserviços, onde cada componente da aplicação (como o gerenciamento de carrinho, pagamento, e busca de produtos) seria desenvolvido e mantido de forma independente. João liderou a equipe na reescrita e segmentação do código, implementando serviços independentes que podiam ser escalados individualmente conforme a demanda. Além disso, ele colaborou com Carlos Mendes, o Designer de UX/UI, para garantir que a nova interface fosse intuitiva e responsiva, melhorando a experiência do usuário em dispositivos móveis e desktop. Após a implementação, a nova arquitetura reduziu o tempo de resposta em 30%, eliminando os problemas de lentidão e falhas, o que resultou em um aumento significativo na satisfação do cliente e na retenção de usuários."));
        customModelArrayList.add(new CustomModel(R.drawable.mulher,"Ana Costa  Gerente de Projetos","Experiência\n" +
                "Ana Costa gerenciou grandes projetos de TI na GlobalTech, incluindo a implementação de sistemas ERP e CRM em empresas multinacionais.\n" +
                "\n" +
                "Problema: Durante o desenvolvimento de uma nova aplicação móvel destinada a um público global, a equipe de marketing e a equipe de desenvolvimento estavam desalinhadas. O marketing planejava uma campanha agressiva baseada em funcionalidades que ainda não estavam totalmente desenvolvidas ou testadas, criando um risco significativo de promessas não cumpridas para os clientes. Isso poderia resultar em uma má recepção do produto no mercado e danos à reputação da empresa.\n" +
                "Solução: Ana percebeu que a chave para o sucesso era alinhar as expectativas e cronogramas das duas equipes. Ela organizou uma série de reuniões conjuntas para garantir que ambos os lados entendessem as prioridades e limitações um do outro. Ana também ajustou o cronograma do projeto, priorizando o desenvolvimento e teste das funcionalidades que o marketing pretendia destacar. Além disso, ela implementou um sistema de comunicação mais eficaz entre as equipes, usando ferramentas como Jira para rastrear o progresso e ajustar a estratégia conforme necessário. Graças à sua intervenção, as funcionalidades críticas foram entregues a tempo e totalmente testadas, permitindo que a equipe de marketing, liderada por Mariana Oliveira, realizasse a campanha como planejado. O lançamento do aplicativo foi um sucesso, com uma taxa de adesão 20% maior do que o esperado e críticas positivas que reforçaram a imagem da marca no mercado."));
        customModelArrayList.add(new CustomModel(R.drawable.mulher2,"Mariana Oliveira  Especialista em Marketing Digital","Experiência\n" +
                "Mariana Oliveira liderou campanhas de marketing digital na MarketPro, focando em aumentar o engajamento e a retenção de usuários em plataformas digitais.\n" +
                "\n" +
                "Problema: O aplicativo móvel da empresa estava enfrentando uma baixa taxa de retenção, com muitos usuários abandonando o aplicativo logo após o download. As análises mostraram que, apesar de um bom número inicial de downloads, poucos usuários continuavam a usar o aplicativo após a primeira semana, o que indicava um problema de engajamento.\n" +
                "Solução: Mariana identificou que a falta de interações personalizadas e lembretes estava contribuindo para o desinteresse dos usuários. Ela propôs a implementação de uma estratégia de marketing automatizada que utilizava notificações push e e-mails personalizados para engajar os usuários em momentos críticos. Trabalhando em conjunto com João Silva, o Desenvolvedor de Software, Mariana definiu gatilhos específicos dentro do aplicativo que acionariam essas mensagens automatizadas, como notificações para concluir um pedido inacabado ou ofertas personalizadas baseadas no comportamento de navegação do usuário. João implementou essas funcionalidades no aplicativo, garantindo que as mensagens fossem enviadas de forma precisa e oportuna. Como resultado, a estratégia de Mariana aumentou o engajamento dos usuários em 25%, revertendo a tendência de abandono e aumentando a retenção a longo prazo."));
        customModelArrayList.add(new CustomModel(R.drawable.homem3,"Carlos Mendes  Designer de UX/UI","Experiência\n" +
                "Carlos Mendes desenvolveu a interface de usuário para uma aplicação de e-commerce na Creative Solutions, focando em melhorar a experiência do usuário e aumentar as conversões.\n" +
                "\n" +
                "Problema: A empresa estava enfrentando um problema sério com a página de destino (landing page) utilizada para campanhas de marketing digital. Apesar de atrair um número significativo de visitantes, a taxa de conversão (percentual de visitantes que realizavam uma ação desejada, como se inscrever ou comprar) era muito baixa. Isso indicava que algo na página estava afastando os usuários antes que eles completassem a ação, prejudicando os resultados das campanhas de PPC (Pay-Per-Click).\n" +
                "Solução: Carlos iniciou uma análise aprofundada da página, realizando testes de usabilidade e entrevistas com usuários para identificar os pontos problemáticos. Ele descobriu que o layout confuso e o excesso de informações na página estavam sobrecarregando os usuários, levando-os a abandonar a página antes de concluir qualquer ação. Carlos então trabalhou junto com Mariana Oliveira, a Especialista em Marketing Digital, para redesenhar a página. Ele simplificou a navegação, destacou os botões de chamada para ação (CTAs) e reduziu o número de etapas necessárias para completar uma inscrição ou compra. Além disso, ele integrou as melhores práticas de SEO sugeridas por Mariana para garantir que a página fosse facilmente encontrada e bem ranqueada nos motores de busca. Com essas mudanças, a taxa de conversão aumentou em 35%, transformando uma página anteriormente problemática em um forte gerador de leads e vendas."));
        customModelArrayList.add(new CustomModel(R.drawable.mulher3,"Juliana Silva  Professora de Educação Infantil","Experiência\n" +
                "Juliana Silva tem 12 anos de experiência como professora de educação infantil, trabalhando em escolas públicas e privadas.\n" +
                "\n" +
                "Problema: Juliana enfrentou o desafio de ensinar uma turma com grande diversidade de habilidades e níveis de desenvolvimento. Alguns alunos estavam avançados para a idade, enquanto outros tinham dificuldades significativas de aprendizado, o que tornava difícil aplicar uma metodologia única para toda a classe.\n" +
                "Solução: Juliana adotou uma abordagem personalizada para o ensino, desenvolvendo planos de aula diferenciados para grupos específicos de alunos. Ela utilizou atividades lúdicas e interativas para engajar os alunos em diferentes níveis, além de promover a colaboração entre eles, incentivando os mais avançados a ajudarem seus colegas. Essa estratégia resultou em uma melhora significativa no desempenho de toda a turma, com alunos apresentando progresso tanto acadêmico quanto social.\n"));
        customModelArrayList.add(new CustomModel(R.drawable.torta,"Receita de Torta de Limão","" +
                " Rafael sempre gostou de cozinhar, mas nunca foi muito experiente em sobremesas. Certo dia, ele decidiu fazer uma torta de limão para surpreender sua esposa no aniversário de casamento. No entanto, ao preparar o recheio, Rafael cometeu um erro crucial: ele misturou o suco de limão com o leite condensado e o creme de leite diretamente na panela, em vez de seguir as instruções para misturar os ingredientes frios.\n" +
                "\n" +
                "O resultado foi um recheio que não ficou homogêneo, com uma textura granulada e um sabor ácido desbalanceado. Rafael ficou frustrado, pensando que havia estragado a surpresa.\n" +
                "\n" +
                "Solução: Determinado a acertar, Rafael pesquisou sobre as propriedades dos ingredientes e descobriu que o segredo estava em respeitar as temperaturas e a ordem de mistura. Ele então começou de novo, desta vez misturando o suco de limão com o leite condensado em uma tigela à parte, deixando a mistura engrossar naturalmente. Depois, adicionou o creme de leite aos poucos, garantindo que o recheio ficasse cremoso e suave.\n" +
                "\n" +
                "Após montar a torta e deixá-la na geladeira, Rafael preparou um merengue para cobrir a torta, torcendo para que tudo desse certo. Quando serviu a sobremesa, sua esposa ficou encantada com o resultado. A torta estava perfeita, com um equilíbrio ideal entre o doce e o ácido, e uma textura leve e cremosa.\n" +
                "\n" +
                "Rafael aprendeu que, na cozinha, às vezes é preciso errar para aprender e que seguir as etapas corretas faz toda a diferença.Ingredientes:\n" +
                "\n" +
                "Para a massa:\n" +
                "\n" +
                "200g de biscoito maisena\n" +
                "100g de manteiga derretida\n" +
                "Para o recheio:\n" +
                "\n" +
                "1 lata de leite condensado\n" +
                "1/2 xícara de suco de limão (aproximadamente 3 limões)\n" +
                "Raspas de 1 limão\n" +
                "1 lata de creme de leite sem soro\n" +
                "Para o merengue (opcional):\n" +
                "\n" +
                "3 claras de ovo\n" +
                "1/2 xícara de açúcar\n" +
                "Modo de Preparo:\n" +
                "\n" +
                "Massa:\n" +
                "\n" +
                "Triture os biscoitos maisena no liquidificador ou processador até virar uma farofa fina.\n" +
                "Misture a farofa com a manteiga derretida até formar uma massa úmida.\n" +
                "Pressione a massa no fundo e nas laterais de uma forma de torta de fundo removível (aproximadamente 22cm de diâmetro).\n" +
                "Leve ao forno preaquecido a 180°C por cerca de 10 minutos, ou até a massa estar levemente dourada. Deixe esfriar.\n" +
                "Recheio:\n" +
                "\n" +
                "Em uma tigela, misture o leite condensado com o suco de limão. A mistura irá engrossar naturalmente.\n" +
                "Adicione o creme de leite e as raspas de limão, e misture bem até ficar homogêneo.\n" +
                "Despeje o recheio sobre a massa já fria e leve à geladeira por pelo menos 4 horas, ou até firmar.\n" +
                "Merengue (opcional):\n" +
                "\n" +
                "Bata as claras em neve até formarem picos suaves.\n" +
                "Gradualmente, adicione o açúcar e continue batendo até obter um merengue firme e brilhante.\n" +
                "Espalhe o merengue sobre o recheio de limão, formando picos com uma colher.\n" +
                "Leve ao forno preaquecido a 200°C por 5 a 10 minutos, ou até o merengue dourar levemente.\n" +
                "Finalização:\n" +
                "\n" +
                "Deixe a torta esfriar completamente antes de desenformar.\n" +
                "Decore com raspas de limão por cima e sirva gelada.\n"));
        customModelArrayList.add(new CustomModel(R.drawable.lasanha,"Receita de Lasanha à Bolonhesa ","Dona Clara sempre foi conhecida por sua habilidade na cozinha, mas em um jantar especial de família, ela enfrentou um grande desafio. Na tentativa de impressionar seus convidados, ela decidiu fazer uma lasanha à bolonhesa pela primeira vez, mas cometeu um erro ao preparar o molho bolonhesa. Em vez de deixar o molho cozinhar lentamente, ela o preparou apressadamente, resultando em um molho aguado e sem sabor.\n" +
                "\n" +
                "Quando percebeu que o molho não estava encorpado como deveria, Dona Clara entrou em pânico. Com os convidados já a caminho, ela sabia que não tinha tempo para começar tudo de novo. Foi então que ela se lembrou dos conselhos de sua antiga amiga, uma chef experiente, que sempre dizia: \"A paciência é o segredo de um bom molho.\"\n" +
                "\n" +
                "Solução: Dona Clara rapidamente transferiu o molho para uma panela mais larga e aumentou o fogo para evaporar o excesso de líquido. Ela adicionou uma colher de extrato de tomate e uma pitada de açúcar para equilibrar o sabor. Enquanto o molho engrossava, ela preparou o restante da lasanha com calma, garantindo que cada camada de massa estivesse perfeitamente cozida.\n" +
                "\n" +
                "No final, a lasanha ficou deliciosa, com um molho bolonhesa encorpado e rico, como se tivesse sido cozido por horas. Os convidados elogiaram o prato, e Dona Clara aprendeu uma lição valiosa sobre a importância de dar tempo ao tempo na cozinha." +
                "Ingredientes:\n" +
                "\n" +
                "Para o molho bolonhesa:\n" +
                "\n" +
                "500g de carne moída (bovina ou mista)\n" +
                "1 cebola grande picada\n" +
                "3 dentes de alho picados\n" +
                "1 cenoura ralada\n" +
                "1 talo de salsão picado (opcional)\n" +
                "2 latas de tomate pelado ou 4 tomates maduros picados\n" +
                "1 colher de sopa de extrato de tomate\n" +
                "1 colher de chá de açúcar\n" +
                "Sal e pimenta a gosto\n" +
                "1 folha de louro\n" +
                "Azeite de oliva para refogar\n" +
                "1/2 xícara de vinho tinto seco (opcional)\n" +
                "Para o molho branco (bechamel):\n" +
                "\n" +
                "50g de manteiga\n" +
                "2 colheres de sopa de farinha de trigo\n" +
                "500ml de leite\n" +
                "Sal, pimenta-do-reino e noz-moscada a gosto\n" +
                "Montagem:\n" +
                "\n" +
                "500g de massa de lasanha pré-cozida\n" +
                "300g de queijo muçarela fatiado ou ralado\n" +
                "100g de queijo parmesão ralado\n" +
                "Folhas de manjericão fresco (opcional)\n" +
                "Modo de Preparo:\n" +
                "\n" +
                "Molho Bolonhesa:\n" +
                "\n" +
                "Aqueça um fio de azeite em uma panela grande e refogue a cebola e o alho até ficarem dourados.\n" +
                "Adicione a cenoura e o salsão, e refogue por mais alguns minutos.\n" +
                "Junte a carne moída, mexendo bem até que ela esteja bem cozida e sem grumos.\n" +
                "Acrescente o vinho tinto (se estiver usando) e deixe evaporar.\n" +
                "Adicione os tomates pelados, o extrato de tomate, o açúcar, o sal, a pimenta e a folha de louro.\n" +
                "Deixe o molho cozinhar em fogo baixo por cerca de 30 a 40 minutos, mexendo de vez em quando, até que engrosse e os sabores estejam bem apurados.\n" +
                "Molho Branco (Bechamel):\n" +
                "\n" +
                "Derreta a manteiga em uma panela média.\n" +
                "Adicione a farinha de trigo e mexa constantemente por cerca de 2 minutos, até formar uma pastinha (roux).\n" +
                "Gradualmente, adicione o leite, mexendo sempre para evitar grumos.\n" +
                "Continue mexendo até o molho engrossar. Tempere com sal, pimenta-do-reino e noz-moscada a gosto.\n" +
                "Montagem:\n" +
                "\n" +
                "Preaqueça o forno a 180°C.\n" +
                "Em um refratário, espalhe uma camada fina de molho bolonhesa.\n" +
                "Coloque uma camada de massa de lasanha por cima.\n" +
                "Cubra com uma camada de molho bolonhesa e uma de molho branco.\n" +
                "Adicione fatias de queijo muçarela.\n" +
                "Repita as camadas até terminar os ingredientes, finalizando com molho branco e uma generosa camada de queijo parmesão ralado.\n" +
                "Leve ao forno por cerca de 30 a 40 minutos, até que a lasanha esteja borbulhando e dourada por cima.\n" +
                "Decore com folhas de manjericão fresco e sirva."));

        customModelArrayList.add(new CustomModel(R.drawable.mulher4,"Ana Especialista em Tecnologia e Consultora de TI ","Ana é uma especialista em tecnologia que trabalha como consultora de TI, ajudando empresas e consumidores a escolher os melhores monitores e telas para suas necessidades. Com uma vasta experiência na área, ela é frequentemente chamada para explicar as diferenças entre os tipos de painéis disponíveis no mercado.\n" +
                "\n" +
                "Painel VA (Vertical Alignment)\n" +
                "Explicação de Ana: “Os painéis VA são uma excelente escolha para quem valoriza contraste e pretos profundos. Eles são ótimos para assistir filmes ou jogar em ambientes escuros. Imagine você assistindo a um filme de terror em um quarto escuro – os pretos profundos do VA tornam a experiência muito mais imersiva. No entanto, se você é um jogador competitivo, o tempo de resposta mais lento pode não ser ideal, já que pode causar borrões em cenas de ação rápida.”\n" +
                "\n" +
                "Painel IPS (In-Plane Switching)\n" +
                "Explicação de Ana: “Se você trabalha com design gráfico, edição de fotos ou vídeos, os painéis IPS são o que você precisa. Eles oferecem uma precisão de cores fantástica e ângulos de visão amplos, o que significa que você pode ver a imagem de qualquer ângulo sem distorção. No entanto, eles não têm o mesmo contraste que os painéis VA, então os pretos não serão tão profundos. Mas para quem precisa de cores consistentes e precisas, o IPS é a melhor escolha.”\n" +
                "\n" +
                "Painel TN (Twisted Nematic)\n" +
                "Explicação de Ana: “Para os gamers que buscam tempos de resposta rápidos e não se importam tanto com a qualidade de imagem, os painéis TN são perfeitos. Eles são mais acessíveis e oferecem o menor tempo de resposta, geralmente abaixo de 1ms, o que é crucial para jogos de ritmo rápido. Mas é importante saber que você sacrificará a qualidade das cores e os ângulos de visão, que são bem limitados em comparação com VA e IPS.”\n" +
                "\n" +
                "Painel OLED (Organic Light-Emitting Diode)\n" +
                "Explicação de Ana: “Os painéis OLED são a joia da coroa quando falamos de qualidade de imagem. Cada pixel emite sua própria luz, então você obtém pretos perfeitos e cores incrivelmente vibrantes. O tempo de resposta também é praticamente instantâneo, o que os torna ideais para qualquer uso, seja assistir filmes, jogar, ou até trabalhar em projetos gráficos. O único problema é o risco de burn-in se você deixar uma imagem estática na tela por muito tempo, e, claro, o preço – os monitores OLED são significativamente mais caros.”\n" +
                "\n" +
                "Resumo de Ana: “Cada tipo de painel tem suas vantagens e desvantagens. Se você precisa de cores precisas e ângulos de visão amplos, vá de IPS. Para um contraste incrível e pretos profundos, VA é a sua escolha. Se você é um gamer que prioriza a velocidade, escolha TN. E se você quer a melhor qualidade de imagem possível e está disposto a pagar por isso, o OLED é o caminho a seguir.”\n" +
                "\n" +
                "Ana se orgulha de ajudar seus clientes a encontrar o monitor perfeito para suas necessidades, sempre explicando de forma clara e objetiva como cada tipo de painel pode influenciar a experiência de uso."));


         customAdepter = new CustomAdepter(this,customModelArrayList);        recyclerView.setAdapter(customAdepter);


    }


    private  void IniciarComponentes(){
        bottom_perfil = findViewById(R.id.bottom_perfil);

    }



}