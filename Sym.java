import java.util.LinkedList;

public class Sym {
	private String type;

	public Sym(String type) {
		this.type = type;
	}

	public String toString() {
		return type;
	}
}

class FuncSym extends Sym {
	String returnType;
	LinkedList<String> paramTypes;
	int numParams;

	public FuncSym(String returnType, int numParams) {
		super("function");
		this.returnType = returnType;
		this.numParams = numParams;
	}

	public void addFormals(LinkedList<String> list) {
		paramTypes = list;
	}

	public String getReturnType() {
		return returnType;
	}

	public int getNumParams() {
		return numParams;
	}

	public LinkedList<String> getParamTypes() {
		return paramTypes;
	}

	public String toString() {
		// make list of formals
		String str = "";
		boolean notfirst = false;
		for (String type : paramTypes) {
			if (notfirst)
				str += ",";
			else
				notfirst = true;
			str += type.toString();
		}

		str += "->" + returnType.toString();
		return str;
	}
}

class StructSym extends Sym {

	public StructSym(String id) {
		super(id);
	}

}

class StructDefSym extends Sym {
	private SymTab symTab;

	public StructDefSym(SymTab table) {
		super("struct-def");
		symTab = table;
	}

	public SymTab getSymTable() {
		return symTab;
	}
}