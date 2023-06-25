-- Ex 1 - Crie uma Tabela chamada clientes

CREATE TABLE CLIENTES (
		ID INT,
		NOME VARCHAR(100),
		TELEFONE VARCHAR(20),
		ENDERECO VARCHAR(150))

-- Ex 2 - Crie um Script para inserir 3 Clientes na tabela

INSERT INTO CLIENTES (ID, NOME, TELEFONE, ENDERECO) VALUES 
			(1, 'Vinicius Silva', '987654', 'Rua Girassol'),
			(2, 'Maria Antonia', '123456', 'Rua Rosas'),
			(3, 'Marcus Vinicius', '654123', 'Rua Itajai')

-- Ex 3 - Crie um script que selecione todos os clientes

SELECT * FROM CLIENTES

-- Ex 4 - Selecione os clientes por Id

SELECT ID FROM CLIENTES

-- Ex 5 - Selecione os clientes por nome Utilizando Like

SELECT * FROM CLIENTES
WHERE NOME LIKE '%IUS%'

-- Ex 6 - Crie um Script para atualizar um cliente

UPDATE CLIENTES
SET ENDERECO = 'Rua do Limão'
WHERE NOME = 'Marcus Vinicius'

-- Ex 7 - Crie o Script para excluir um cliente

DELETE FROM CLIENTES
WHERE ID = 2

-- Ex 8 - Normalize a tabela funcionarios até sua terceira forma normal

CREATE TABLE FUNCIONARIOS (ID INT PRIMARY KEY, 
						   NOME VARCHAR(50), 
						   CARGO VARCHAR(50), 
						   TEL1 VARCHAR(20), 
						   TEL2 VARCHAR(20))

INSERT INTO FUNCIONARIOS (ID, NOME, CARGO, TEL1, TEL2) VALUES 
			(1,'Marcos', 'Atendente', '3654589', '36545987'),
			(2, 'Maria', 'Gerente', '3654698', '36524569'),
			(3, 'Julia', 'Atendente', '3654962', '12365458')

ALTER TABLE FUNCIONARIOS DROP TEL1
ALTER TABLE FUNCIONARIOS DROP TEL2

CREATE TABLE TELEFONES (FUNCIONARIO_ID INT REFERENCES FUNCIONARIOS(ID),
						TELEFONE VARCHAR(20),
						PRIMARY KEY (FUNCIONARIO_ID, TELEFONE))

INSERT INTO TELEFONES VALUES 
						(1,'3654589'),
						(1,'36545987'),
						(2, '3654698'),
						(2, '36524569'),
						(3, '3654962'),
						(3, '12365458')

ALTER TABLE FUNCIONARIOS DROP CARGO

CREATE TABLE CARGO (ID INT PRIMARY KEY,
				   DESCRICAO VARCHAR(100))

INSERT INTO CARGO VALUES 
					(1, 'Atendente'),
					(2, 'Gerente')

ALTER TABLE FUNCIONARIOS ADD COLUMN CARGO_ID INT

ALTER TABLE FUNCIONARIOS ADD CONSTRAINT CARGOS_ID_FK FOREIGN KEY(CARGO_ID) REFERENCES CARGO(ID)

UPDATE FUNCIONARIOS
SET CARGO_ID = 1
WHERE ID = 1

UPDATE FUNCIONARIOS
SET CARGO_ID = 2
WHERE ID = 2

UPDATE FUNCIONARIOS
SET CARGO_ID = 1
WHERE ID = 3

-- EX 9 - Crie um script para selecionar os dados da estrutura criada no exercício 8

SELECT * FROM FUNCIONARIOS
JOIN TELEFONES ON TELEFONES.FUNCIONARIO_ID = FUNCIONARIOS.ID
JOIN CARGO ON FUNCIONARIOS.CARGO_ID = CARGO.ID