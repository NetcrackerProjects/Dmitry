package netcracker.study.repository;

import netcracker.study.api.repository.ProjectRepository;
import netcracker.study.entity.Project;
import org.junit.Assert;
import org.junit.Test;

public class ProjectRepositoryTest {

    @Test
    public void testAddProjectPositive() {
        ProjectRepository projectRepository = new ProjectRepositoryImpl();
        Project project = new Project();

        projectRepository.addProject(project);

        Assert.assertTrue(projectRepository.getProjectsMap().containsKey(project.getId()));
    }

    @Test(expected = NullPointerException.class)
    public void testAddProjectNegative() {
        ProjectRepository ProjectRepository = new ProjectRepositoryImpl();

        ProjectRepository.addProject(null);
    }

    @Test
    public void testUpdateProjectPositive() {
        String updatedName = "updated project name";
        ProjectRepository projectRepository = new ProjectRepositoryImpl();
        Project project = new Project();

        projectRepository.addProject(project);
        Project createdProject = projectRepository.getProjectByOrderIndex(0);
        createdProject.setName(updatedName);
        projectRepository.updateProject(createdProject);
        String updatedProjectName = projectRepository.getProjectsMap().get(createdProject.getId()).getName();

        Assert.assertEquals(updatedName, updatedProjectName);
    }

    @Test(expected = NullPointerException.class)
    public void testUpdateProjectNegative() {
        ProjectRepository ProjectRepository = new ProjectRepositoryImpl();

        ProjectRepository.updateProject(null);
    }

    @Test
    public void testDeleteProjectByIdPositive() {
        ProjectRepository projectRepository = new ProjectRepositoryImpl();
        Project project = new Project();

        projectRepository.addProject(project);
        projectRepository.deleteProjectByOrderIndex(0);

        Assert.assertTrue(projectRepository.getProjectsMap().isEmpty());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteProjectByIdNegative() {
        ProjectRepository ProjectRepository = new ProjectRepositoryImpl();

        ProjectRepository.deleteProjectByOrderIndex(0);
    }
}