CREATE DATABASE IF NOT EXISTS Supermercado_BD;
USE Supermercado_BD;

CREATE TABLE IF NOT EXISTS Servico 
( 
    ID_servico INT PRIMARY KEY AUTO_INCREMENT,  
    Valor FLOAT NOT NULL,  
    Modalidade VARCHAR(50) NOT NULL,  
    Descricao VARCHAR(200) NOT NULL
);

CREATE TABLE IF NOT EXISTS Login 
(  
    Nome VARCHAR(60) NOT NULL,  
    CPF_CNPJ VARCHAR(60) NOT NULL,  
    idLogin INT PRIMARY KEY AUTO_INCREMENT, 
    idAdmin BOOLEAN
); 

CREATE TABLE IF NOT EXISTS Produtos 
(  
    Nome VARCHAR(60) NOT NULL PRIMARY KEY,  
    preco DECIMAL(10,2) NOT NULL,  
    descricao VARCHAR(300),
    quantidade INT NOT NULL DEFAULT 0
); 

INSERT INTO Login (Nome, CPF_CNPJ, idAdmin)
SELECT 'Admin', 'default', TRUE
WHERE NOT EXISTS (
    SELECT 1 FROM Login WHERE Nome = 'Admin'
);

INSERT INTO Produtos (Nome, preco, descricao, quantidade) VALUES
    ('Arroz', 20.99, 'Arroz branco tipo 1', 50)
    ON DUPLICATE KEY UPDATE preco=VALUES(preco), descricao=VALUES(descricao), quantidade=VALUES(quantidade);

INSERT INTO Produtos (Nome, preco, descricao, quantidade) VALUES
    ('Feijao', 12.50, 'Feijão carioca', 30)
    ON DUPLICATE KEY UPDATE preco=VALUES(preco), descricao=VALUES(descricao), quantidade=VALUES(quantidade);

INSERT INTO Produtos (Nome, preco, descricao, quantidade) VALUES
    ('Macarrao', 7.99, 'Macarrão espaguete', 40)
    ON DUPLICATE KEY UPDATE preco=VALUES(preco), descricao=VALUES(descricao), quantidade=VALUES(quantidade);

SELECT * FROM Login;
SELECT * FROM Produtos;
