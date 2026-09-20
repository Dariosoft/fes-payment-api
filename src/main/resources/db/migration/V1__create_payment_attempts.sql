CREATE TABLE payment_attempts (
    id UUID PRIMARY KEY,
    order_id UUID NOT NULL,
    provider VARCHAR(40) NOT NULL,
    provider_reference VARCHAR(200),
    status VARCHAR(40) NOT NULL,
    idempotency_key VARCHAR(200) NOT NULL UNIQUE,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);
CREATE INDEX payment_attempts_order_id_idx ON payment_attempts (order_id);
