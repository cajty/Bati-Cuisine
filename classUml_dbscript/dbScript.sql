



CREATE TYPE project_status_enum AS ENUM ('IN_PROGRESS', 'COMPLETED', 'CANCELLED');
CREATE TYPE component_type_enum AS ENUM ('MATERIAL', 'LABOR');


CREATE TABLE clients (
                         client_id SERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL UNIQUE,
                         address TEXT NOT NULL,
                         phone VARCHAR(20),
                         is_professional BOOLEAN NOT NULL DEFAULT FALSE

);


CREATE TABLE projects (
                          project_id SERIAL PRIMARY KEY,
                          project_name VARCHAR(255) NOT NULL UNIQUE,
                          profit_margin NUMERIC(5, 2) NOT NULL DEFAULT 0.0 CHECK (profit_margin >= 0),
                          total_cost NUMERIC(12, 2) NOT NULL DEFAULT 0.0 CHECK (total_cost >= 0),
                          project_status project_status_enum NOT NULL DEFAULT 'IN_PROGRESS',
                          client_id INT NOT NULL,
                          FOREIGN KEY (client_id) REFERENCES clients(client_id) ON DELETE CASCADE
);


CREATE TABLE components (
                            component_id SERIAL PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
                            component_type component_type_enum NOT NULL,
                            vat_rate NUMERIC(5, 2) NOT NULL CHECK (vat_rate >= 0),
                            project_id INT NOT NULL,
                            FOREIGN KEY (project_id) REFERENCES projects(project_id) ON DELETE CASCADE

);


CREATE TABLE materials (
                           component_id INT PRIMARY KEY,
                           unit_cost NUMERIC(12, 2) NOT NULL CHECK (unit_cost >= 0),
                           quantity NUMERIC(12, 2) NOT NULL CHECK (quantity > 0),
                           transport_cost NUMERIC(12, 2) DEFAULT 0 CHECK (transport_cost >= 0),
                           quality_coefficient NUMERIC(5, 2) DEFAULT 1 CHECK (quality_coefficient > 0),
                           FOREIGN KEY (component_id) REFERENCES components(component_id) ON DELETE CASCADE
);


CREATE TABLE labor (
                       component_id INT PRIMARY KEY,
                       hourly_rate NUMERIC(12, 2) NOT NULL CHECK (hourly_rate > 0),
                       work_hours NUMERIC(12, 2) NOT NULL CHECK (work_hours > 0),
                       worker_productivity NUMERIC(5, 2) DEFAULT 1 CHECK (worker_productivity > 0),
                       labor_type VARCHAR(255) NOT NULL,
                       FOREIGN KEY (component_id) REFERENCES components(component_id) ON DELETE CASCADE
);


CREATE TABLE estimates (
                           estimate_id SERIAL PRIMARY KEY,
                           estimated_amount NUMERIC(12, 2) NOT NULL CHECK (estimated_amount > 0),
                           issue_date DATE NOT NULL,
                           validity_date DATE NOT NULL CHECK (validity_date >= issue_date),
                           is_accepted BOOLEAN NOT NULL DEFAULT FALSE,
                           project_id INT NOT NULL,
                           FOREIGN KEY (project_id) REFERENCES projects(project_id) ON DELETE CASCADE
);















