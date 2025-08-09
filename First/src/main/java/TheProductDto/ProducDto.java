package TheProductDto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProducDto {


public ProducDto(int pid, int pdesc, String pname) {
		super();
		this.pid = pid;
		this.pdesc = pdesc;
		this.pname = pname;
	}
@JsonIgnore
public int pid;
public int pdesc;
public String  pname;
}
