CREATE TABLE ESTACIONAMENTO(
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(100),
    telefone VARCHAR(11),
    precohora DECIMAL(5,2),
    quantvagas INT,
    CONSTRAINT PK_Estacionamento PRIMARY KEY (id, nome)
);

CREATE TABLE CLIENTE(
    id INT NOT NULL AUTO_INCREMENT,
    cpf VARCHAR(11) NOT NULL,
    nome VARCHAR(50),
    telefone VARCHAR(11),
    endereco VARCHAR(100),
    placa VARCHAR(7) NOT NULL,
    modelo VARCHAR(20),
    fabricante VARCHAR(20),
    cor VARCHAR(10),
    CONSTRAINT PK_Cliente PRIMARY KEY (id)
);

CREATE TABLE VAGA(
    id INT NOT NULL AUTO_INCREMENT,
    disponivel TINYINT,
    CONSTRAINT PK_Vaga PRIMARY KEY (id)
);

CREATE TABLE ALUGUEL(
    id INT NOT NULL AUTO_INCREMENT,
    cliente INT,
    vagaid INT,
    horaentrada timestamp,
    horasaida timestamp,
    valortotal DECIMAL(5,2),
    CONSTRAINT PK_Aluguel PRIMARY KEY (id),
    CONSTRAINT FK_Aluguel1 FOREIGN KEY (cliente) REFERENCES CLIENTE(id) ON DELETE CASCADE,
    CONSTRAINT FK_Aluguel2 FOREIGN KEY (vagaid) REFERENCES VAGA(id) ON DELETE CASCADE
);

CREATE TABLE FUNCIONARIO(
    id INT NOT NULL AUTO_INCREMENT,
    cpf VARCHAR(11) NOT NULL,
    nome VARCHAR(50),
    senha VARCHAR(20),
    telefone VARCHAR(11),
    CONSTRAINT PK_Funcionario PRIMARY KEY (id, cpf)
);
