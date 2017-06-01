package View;
import java.util.List;
import org.uqbar.commons.utils.Observable;
import Modelo.BolsaDeEmpresas;
import Modelo.Empresa;
import Modelo.IndicadorBuilder;

@Observable
public class VMOperando {

IndicadorBuilder miIndicadorBuilder;

	//Constructor
	public VMOperando(IndicadorBuilder indicadorBuilder) {
		super();
		this.miIndicadorBuilder = indicadorBuilder;
		
	}

	public IndicadorBuilder getMiIndicadorBuilder() {
		return miIndicadorBuilder;
	}

	public void setMiIndicadorBuilder(IndicadorBuilder miIndicadorBuilder) {
		this.miIndicadorBuilder = miIndicadorBuilder;
	}
}