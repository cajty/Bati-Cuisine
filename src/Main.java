
import model.Client;
import model.Project;
import model.ProjectStatus;
import repository.ClientRepository;
import repository.ProjectRepository;
import repository.impl.ClientRepositoryImpl;
import repository.impl.ProjectRepositoryImpl;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ClientRepository clientRepository = new ClientRepositoryImpl();
        ProjectRepository projectRepository = new ProjectRepositoryImpl();

        Client client1 = new Client( "John", "New York", "123456", true);
        clientRepository.addClient(client1);
        Client client2 = new Client( "Jane", "Los Angeles", "654321", false);
        clientRepository.addClient(client2);

Project project1 = new Project("Project 1", 0.1, 1000, ProjectStatus.IN_PROGRESS, 1);

        projectRepository.addProject(project1);
        Project project2 = new Project("Project 2", 0.2, 2000, ProjectStatus.IN_PROGRESS, 2);
        projectRepository.addProject(project2);
        Project project3 = new Project("Project 3", 0.3, 3000, ProjectStatus.IN_PROGRESS, 1);
        projectRepository.addProject(project3);
        Project project4 = new Project("Project 4", 0.4, 4000, ProjectStatus.IN_PROGRESS, 2);
        projectRepository.addProject(project4);

        projectRepository.getAllProjects().ifPresent(projects -> {
            for (Project project : projects) {
                System.out.println(project.toString());
            }
        });

        clientRepository.getClientOfProject(1).ifPresent(client -> {
            System.out.println(client);
        });


    }
}