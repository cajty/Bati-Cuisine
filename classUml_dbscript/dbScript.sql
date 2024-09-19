-- Table: Clients
CREATE TABLE Clients (
                         client_id SERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         address TEXT NOT NULL,
                         phone VARCHAR(20),
                         is_professional BOOLEAN NOT NULL DEFAULT FALSE
);

-- Table: Projects
CREATE TABLE Projects (
                          project_id SERIAL PRIMARY KEY,
                          project_name VARCHAR(255) NOT NULL,
                          profit_margin NUMERIC(5, 2) NOT NULL,
                          total_cost NUMERIC(12, 2),
                          project_status VARCHAR(50) NOT NULL DEFAULT 'In Progress' CHECK (project_status IN ('In Progress', 'Completed', 'Cancelled')),
                          client_id INT REFERENCES Clients(client_id) ON DELETE CASCADE
);

-- Table: Components (parent table for Materials and Labor)
CREATE TABLE Components (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
                            component_type VARCHAR(50) NOT NULL CHECK (component_type IN ('Material', 'Labor')),
                            vat_rate NUMERIC(5, 2) NOT NULL,
                            project_id INT REFERENCES Projects(project_id) ON DELETE CASCADE
);

-- Table: Materials (inherits from Components)
CREATE TABLE Materials (
                           unit_cost NUMERIC(12, 2) NOT NULL,
                           quantity NUMERIC(12, 2) NOT NULL,
                           transport_cost NUMERIC(12, 2) DEFAULT 0,
                           quality_coefficient NUMERIC(5, 2) DEFAULT 1,
                           PRIMARY KEY (id)

) INHERITS (Components);

-- Table: Labor (inherits from Components)
CREATE TABLE Labor (
                       hourly_rate NUMERIC(12, 2) NOT NULL,
                       work_hours NUMERIC(12, 2) NOT NULL,
                       worker_productivity NUMERIC(5, 2) DEFAULT 1,
                       labor_type VARCHAR(255) NOT NULL,
                       PRIMARY KEY (id)
) INHERITS (Components);

-- Table: Estimates
CREATE TABLE Estimates (
                           estimate_id SERIAL PRIMARY KEY,
                           estimated_amount NUMERIC(12, 2) NOT NULL,
                           issue_date DATE NOT NULL,
                           validity_date DATE NOT NULL CHECK (validity_date >= issue_date),
                           is_accepted BOOLEAN NOT NULL DEFAULT FALSE,
                           project_id INT REFERENCES Projects(project_id) ON DELETE CASCADE
);
