package model;



public class Labor extends Component  {


    private int laborId;
    private int componentId;
    private double hourlyRate;
    private double workHours;
    private double workerProductivity;
    private String laborType;

    public Labor(int laborId, int componentId, double hourlyRate, double workHours, double workerProductivity, String laborType) {
        this.laborId = laborId;
        this.componentId = componentId;
        this.hourlyRate = hourlyRate;
        this.workHours = workHours;
        this.workerProductivity = workerProductivity;
        this.laborType = laborType;

    }

    // Getters and Setters
    public int getLaborId() {
        return laborId;
    }

    public void setLaborId(int laborId) {
        this.laborId = laborId;
    }

    public int getComponentId() {
        return componentId;
    }

    public void setComponentId(int componentId) {
        this.componentId = componentId;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getWorkHours() {
        return workHours;
    }

    public void setWorkHours(double workHours) {
        this.workHours = workHours;
    }

    public double getWorkerProductivity() {
        return workerProductivity;
    }

    public void setWorkerProductivity(double workerProductivity) {
        this.workerProductivity = workerProductivity;
    }

    public String getLaborType() {
        return laborType;
    }

    public void setLaborType(String laborType) {
        this.laborType = laborType;
    }
}

