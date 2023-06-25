-- Ex 1 - Crie uma Tabela chamada clientes

CREATE TABLE CLIENTES (
		ID INT,
		NOME VARCHAR(100),
		TELEFONE VARCHAR(20),
		ENDERECO VARCHAR(150),
)

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

-- EX 9 - Crie um script para selecionar os dados da estrutura criada no exercício 8