import java.util.LinkedList;

public class Sym {
	private String type;

	public Sym(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
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
	// new fields
	public IdNode structType; // name of the struct type

	public StructSym(IdNode id) {
		super(id.toString());
		structType = id;
	}

	public IdNode getStructType() {
		return structType;
	}
}

/**
 * The StructDefSym class is a subclass of the Sym class just for the
 * definition of a struct type.
 * Each StructDefSym contains a symbol table to hold information about its
 * fields.
 */
class StructDefSym extends Sym {
	// new fields
	private SymTab symTab;

	public StructDefSym(SymTab table) {
		super("");
		symTab = table;
	}

	public SymTab getSymTable() {
		return symTab;
	}
}