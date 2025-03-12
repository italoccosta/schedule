CREATE TABLE agendamentos (
    id BIGINT PRIMARY KEY,
    data_atendimento TIMESTAMP NOT NULL,
    hora TIMESTAMP NOT NULL,
    status_agendamento VARCHAR(30) NOT NULL,
    criado_em TIMESTAMP,
    cliente_id BIGINT NOT NULL,
    CONSTRAINT fk_cliente FOREIGN KEY (cliente_id) REFERENCES clientes(id) ON DELETE CASCADE
);