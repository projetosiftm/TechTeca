create database tech_teca;
use tech_teca;

create table Administrador (
	id_administrador int primary key auto_increment,
    nome varchar(100),
    telefone char(15),
    email varchar(50)
);

create table Funcionario (
	id_funcionario int primary key auto_increment,
    nome varchar(100),
    telefone char(15),
    email varchar(50)
);

create table Livro (
	id_livro int primary key auto_increment,
    titulo varchar(50),
    autor varchar(100),
    descricao text,
    ano varchar(4),
    editora varchar(50),
    idioma varchar(15),
    isbn char(15),
    foto varchar(100),
    id_administrador int,
    foreign key (id_administrador) references Administrador(id_administrador)
);


create table Usuario (
	id_usuario int primary key auto_increment,
    nome varchar(100),
    telefone char(15),
    email varchar(50),
    endereco varchar(100),
    cpf char(15),
    id_administrador int,
    foreign key (id_administrador) references Administrador (id_administrador)
);

create table Emprestimo (
	id_emprestimo int primary key auto_increment,
    data_emprestimo varchar(10),
    data_devolucao varchar(10),
    id_funcionario int,
    id_usuario int,
    foreign key (id_funcionario) references Funcionario (id_funcionario),
    foreign key (id_usuario) references Usuario (id_usuario)
);

create table Exemplar (
	id_exemplar int primary key auto_increment,
    disponibilidade varchar(20),
    id_livro int,    
    foreign key (id_livro) references Livro (id_livro)
);

create table Reserva (
	id_reserva int primary key auto_increment,
    data_reserva varchar(10),
    status_reserva varchar(20),
    id_usuario int,
    id_emprestimo int,
    foreign key (id_usuario) references Usuario (id_usuario),
    foreign key (id_emprestimo) references Emprestimo (id_emprestimo)
);

create table item_reserva (
	id_item_reserva int primary key auto_increment,
    id_reserva int,
    id_exemplar int,
    id_livro int,
    foreign key (id_reserva) references Reserva (id_reserva),
    foreign key (id_exemplar) references Exemplar (id_exemplar)
);

create table item_emprestimo (
	id_item_emprestimo int primary key auto_increment,
    id_exemplar int,
    id_emprestimo int,
    foreign key (id_emprestimo) references Emprestimo (id_emprestimo),
    foreign key (id_exemplar) references Exemplar (id_exemplar)
);

create table Multa (
	id_multa int primary key auto_increment,
    data_vencimento_multa varchar(10),
    valor_multa numeric(5, 2),
    id_administrador int,
    id_emprestimo int,
    id_item_emprestimo int,
    foreign key (id_administrador) references administrador (id_administrador),
    foreign key (id_emprestimo) references Emprestimo (id_emprestimo),
    foreign key (id_item_emprestimo) references item_emprestimo (id_item_emprestimo)
);

create table Credenciais (
	id_credencial int primary key auto_increment,
    id_pessoa int,
    usuario varchar(50),
    senha varchar(50)
);

create table Logar (
	id_logar int primary key auto_increment,
    id_usuario int,
    id_funcionario int,
    id_adiministrador int,
    id_credencial int,
    foreign key (id_usuario) references Usuario (id_usuario),
    foreign key (id_funcionario) references Funcionario (id_funcionario),
    foreign key (id_administrador) references Administrador (id_administrador),
    foreign key (id_credencial) references Credencial (id_credencial)
);

insert into administrador(nome, telefone, email) values
	("Maria Betania", 11696924240, "maria.betania@gmail.com"),
    ("joana pereira", 88988996655, "joana.pereira@gmail.com"),
    ("Jose Roberto", 34964642424, "jose.roberto@gmail.com"),
    ("Maria Candida", 34999696969, "maria.candida@gmail.com"),
    ("Marcos Candido", 89955443388, "marcos.candido@gmail.com"),
    ("Daiana Candida", 89934523789, "daiana.candida@gmail.com"),
    ("Jucilene Pereira", 85976543112, "jucilene.pereira@gmail.com"),
    ("Maxsuelem Pereira", 88988765432, "maxsuelem.pereira@gmail.com"),
    ("Cricia do Nascimento", 34986754563, "cricia.nascimento@gamil.com"),
    ("Renato Aragão", 11955558888, "renato.aragao@gmail.com");
    
insert into funcionario (nome, telefone, email) values
    ("Jean Borges", 34988776655, "jean.borges@gmail.com"),
    ("Mateus Figueiredo", 8955443322, "mateus.figueiredo@gmail.com"),
    ("Wend Marieta", 1177665533, "wend.marieta@gmail.com"),
    ("Maicon Jefferson", 1277229900, "maicon.jefferson@gmail.com"),
    ("Hugo César", 1234567891, "hugcrs@gmail.com"),
    ("Maria Joaquina", 12772266600, "majo@gmail.com"),
    ("Isa Almeida", 2277229901, " isas@gmail.com"),
    ("Jefferson Maicon", 3432345678, "jefferson.maicon@gmail.com"),
    ("Jussara Helena", 2177229900, "jussarah@gmail.com"),
    ("Jurema Santos", 5577228800, "juremas@gmail.com");


insert into Usuario (nome, telefone, email, endereco, cpf, id_administrador) values
	("Alice Nunes", 34999415199, "alicewonderfull@gmail.com", "Av Floriano Peixoto", 01558965488,1),
	("Sophia Borges", 34988599090, "sophiborges@gmail.com", "Av Delmira Candida", 32298755512,2),
	("Gabriel Ferreira Neto", 38997778555, "gabrielneto@gmail.com", "R da Mata", 95963255477,3),
	("Lucas Tostes", 31988664412, "tosteslucas@gmail.com", "Av Karaiba", 85741265811,4),
	("Jefferson Silva", 32999554477, "jeffsilva@gmail.com", "Av Amazonas", 32145698745,5),
	("Amanda Almeida", 32988554422, "amandaalmei@gmail.com", "Av Das Nacoes", 55578912345,6),
	("Isabel Garcia", 34988662255, "garciaisa@gmail.com", "R Ipiranga", 77765233385,7),
	("Luiz Otavio", 35988556623, "otavioluiz@gmail.com", "R Uirapuru", 65633357812,8),
	("Yago Damasceno", 34988775612, "yagodama@gmail.com", "Av das Flores", 88866624578,9),
	("Heloise Gal", 34988556712, "heloisegal@gmail.com", "R Maria das Dores", 56823178912,10);
    
    
insert into Livro (titulo, autor, descricao, ano, editora, idioma, isbn, foto, id_administrador) values
	("O homem mais feliz da história","Augusto Cury", "O homem que era mais feliz do mundo que já existiu", 2017, "Sextante","Português", 8543105277, "homem_feliz.png", 1),
	("Introdução à Programação com Python","Nilo Ney Coutinho Menezes", "Este livro é orientado ao iniciante em programação", 2016, "Novatec", "Português", 9543105277, "introducaoPy.png", 2),
	("Fundamentos da Programação","Ana Fernanda Gomes Ascencio", "Fundamentos da programação de computadores: algoritmos, PASCAL, C/C++ (padrão ANSI) e JAVA", 2018, "Pearson", "Português", 1543105277, "fundamentos.png", 3),
	("Algoritmos: Logica de programação","Mario Carlos", "A obra aborda aspectos históricos, como origem, fundamentação, breve análise da programação estruturada", 2020, "Cnca", "Português", 1443105277, "algoritmos.png", 4),
	("Inteligência Funcional","Jonas Silva", "Programação mental para o sucesso", 2019, "Foco", "Português",  9788582423295, "inteligencia.png", 5),
	("Programação de Games com Java","Jonathan S. Harbour", "Um guia pratico, perfeito para programadores iniciantes de games que desejam aprender de forma rapida e facil a criar jogos usando Java.", 2018, "Cengage", "Português", 1233455277, "games.png", 6),
	("Algoritmos e Programação em Linguagem C","RENATO KRAIDE SOFFNER", "Este livro trata dos algoritmos básicos de sequência, decisão e repetição.", 2010, "Saraiva", "Português", 2223105277, "algoritmos.png", 7),
	("Introdução à linguagem Lua","Jose Augusto Navarro","Este livro apresenta a linguagem Lua de maneira básica", 2009, "Novatec", "Português", 6663105277, "lua.png", 8),
	("Conhecimento em TI","Miguel Fernandes","Conhecimento em TI e um livro sobre como usar a TI para direcionar resultados finais.", 2016, "Saraiva", "Português", 6793105277, "ti.png", 9),
	("A cor púrpura","Alice Walker", "Nova edição revisada, em novo formato e com nova capa da obra-prima de Alice Walker vencedora do Pulitzer Um dos mais importantes títulos de toda a história da literatura, inspiração para a aclamada obra cinematográfica homônima dirigida por Steven Spielberg",2009, "Ática", "Português", 9788503010313, "cor_pura.png", 10),
	("O codigo da inteligência", "Augusto Cury","Esse livro fala do codigo que dá inteligencia", 2008, "Sextante","Português", 854317637277, "codigo_inteligencia.png", 1), 
	("Alice no pais das maravilhas","Alice Walker", "Esse livro conta a a história no pais das maravilhas",2009, "Ática", "Português", 9788503010313, "alice.png", 2);

insert into Exemplar (disponibilidade, id_livro) values
	("Disponivel", 1),
    ("Indisponivel", 2),
    ("Disponivel", 3),
    ("Indisponivel", 4),
    ("Disponivel", 5),
    ("Indisponivel", 6),
    ("Disponivel", 7),
    ("Indisponivel", 8),
    ("Disponivel", 9),
    ("Indisponivel", 10),
    ("Disponível", 11),
    ("Disponível", 12);
    
insert into Emprestimo (data_emprestimo, data_devolucao, id_funcionario, id_usuario) values
	("2020-06-20","2020-06-27",1,1),
    ("2020-06-19","2020-06-26",2,2),
    ("2020-06-18","2020-06-25",3,3),
    ("2020-06-17","2020-06-24",4,4),
    ("2020-06-16","2020-06-23",5,5),
    ("2020-05-01","2020-05-29",6,6),
    ("2020-05-10","2020-05-15",7,7),
    ("2020-04-07","2020-04-23",8,8),
    ("2020-05-07","2020-06-25",9,8),
    ("2020-06-07","2020-06-24",10,7);


insert into Reserva (data_reserva, status_reserva, id_usuario, id_emprestimo) values
	("2020-06-19","Disponivel", 1, 1),
    ("2020-06-18","Disponivel", 2, 2),
    ("2020-06-09","Indisponivel", 3, 3),
    ("2020-06-16","Disponivel", 4, 4),
    ("2020-06-08","Indisponivel", 5, 5),
    ("2020-05-05","Disponivel",6, 6),
    ("2020-05-01","Indispoivel",7, 7),
    ("2020-04-05","Disponivel",8, 8);
    
insert into item_reserva (id_reserva, id_exemplar, id_livro) values
	(1, 1, 1),
    (2, 2, 2),
    (3, 3, 3),
    (4, 4, 4),
    (5, 5, 5),
    (6, 6, 6),
    (7, 7, 7),
    (8, 8, 8);

insert into item_emprestimo (id_exemplar, id_emprestimo) values 
	(1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5),
    (6, 6),
    (7, 7),
    (8, 8),
    (8, 9),
    (7, 10);
    
insert into Multa (data_vencimento_multa, valor_multa, id_administrador, id_emprestimo, id_item_emprestimo) values
	("2020-06-30", 5, 1, 5, 5),
    ("2020-07-15", 10, 2, 4, 4),
    ("2020-08-10", 8, 2, 2, 2),
    ("2020-10-11", 8, 2, 7, 7),
    ("2020-07-05", 8, 2, 8, 8),
    ("2020-10-20", 8, 2, 8, 9),
    ("2020-08-15", 8, 2, 7, 10);
