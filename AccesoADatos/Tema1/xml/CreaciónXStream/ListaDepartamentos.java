import java.util.ArrayList;
import java.util.List;

public class ListaDepartamentos {
    private List<Departamento> listDepartamentos = new ArrayList<>();

    ListaDepartamentos(){

    }

    public void add(Departamento departamento) {
        listDepartamentos.add(departamento);
    }

    public List<Departamento> getListDepartamentos() {
        return listDepartamentos;
    }
}
