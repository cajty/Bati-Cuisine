package model;



public class Labor extends Component  {


    private double hourlyRate;
    private double workHours;
    private double workerProductivity;
    private String laborType;

   public Labor(String name, ComponentType componentType, double vatRate, int projectId, double hourlyRate, double workHours, double workerProductivity, String laborType) {
    super(name, componentType, vatRate, projectId);
    this.hourlyRate = hourlyRate;
    this.workHours = workHours;
    this.workerProductivity = workerProductivity;
    this.laborType = laborType;
}
    public Labor(String name, double vatRate,  double hourlyRate, double workHours, double workerProductivity, String laborType) {
        super(name, vatRate);
        this.hourlyRate = hourlyRate;
        this.workHours = workHours;
        this.workerProductivity = workerProductivity;
        this.laborType = laborType;
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


    @Override
    public String toString() {
        return "Labor{" +
                "name='" + super.getName() + '\'' +
                "vatRate='" + super.getVatRate() + '\'' +
                "hourlyRate=" + hourlyRate +
                ", workHours=" + workHours +
                ", workerProductivity=" + workerProductivity +
                ", laborType='" + laborType + '\'' +
                '}';
    }
}

