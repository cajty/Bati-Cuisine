
CREATE TABLE Clients (
                         client_id SERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         address TEXT NOT NULL,
                         phone VARCHAR(20),
                         is_professional BOOLEAN NOT NULL
);


CREATE TABLE Projects (
                          project_id SERIAL PRIMARY KEY,
                          project_name VARCHAR(255) NOT NULL,
                          profit_margin DOUBLE PRECISION NOT NULL,
                          total_cost DOUBLE PRECISION,
                          project_status VARCHAR(50) CHECK (project_status IN ('In Progress', 'Completed', 'Cancelled')),
                          client_id INT REFERENCES Clients(client_id) ON DELETE CASCADE
);


CREATE TABLE Components (
                            component_id SERIAL PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
                            component_type VARCHAR(50) NOT NULL CHECK (component_type IN ('Material', 'Labor')),
                            vat_rate DOUBLE PRECISION NOT NULL,
                            project_id INT REFERENCES Projects(project_id) ON DELETE CASCADE
);


CREATE TABLE Materials (
                           material_id SERIAL PRIMARY KEY,
                           component_id INT REFERENCES Components(component_id) ON DELETE CASCADE,
                           unit_cost DOUBLE PRECISION NOT NULL,
                           quantity DOUBLE PRECISION NOT NULL,
                           transport_cost DOUBLE PRECISION,
                           quality_coefficient DOUBLE PRECISION
);


CREATE TABLE Labor (
                       labor_id SERIAL PRIMARY KEY,
                       component_id INT REFERENCES Components(component_id) ON DELETE CASCADE,
                       hourly_rate DOUBLE PRECISION NOT NULL,
                       work_hours DOUBLE PRECISION NOT NULL,
                       worker_productivity DOUBLE PRECISION,
                       labor_type VARCHAR(255) NOT NULL
);


CREATE TABLE Estimates (
                           estimate_id SERIAL PRIMARY KEY,
                           estimated_amount DOUBLE PRECISION NOT NULL,
                           issue_date DATE NOT NULL,
                           validity_date DATE NOT NULL,
                           is_accepted BOOLEAN NOT NULL,
                           project_id INT REFERENCES Projects(project_id) ON DELETE CASCADE
);
