package br.com.fti.sifin.tenancy;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import br.com.fti.sifin.entidades.global.Empresa;
import br.com.fti.sifin.util.R42Util;

@MappedSuperclass
@FilterDef(name = "tenant", parameters = { @ParamDef(name = "id", type = "long") })
@Filter(name = "tenant", condition = "zempresa = :id")
public class ZEmpresa {

	@Column(name = "zempresa")
	private Long zempresa;

	public Long getZempresa() {
		return zempresa;
	}

	public void setZempresa(Long zempresa) {
		this.zempresa = zempresa;
	}

	@PrePersist
	@PreUpdate
	private void definirEmpresa() {
		Empresa empresa = R42Util.resgataEmpresa();
		if (empresa != null) {
			this.zempresa = empresa.getIdEmpresa();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((zempresa == null) ? 0 : zempresa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZEmpresa other = (ZEmpresa) obj;
		if (zempresa == null) {
			if (other.zempresa != null)
				return false;
		} else if (!zempresa.equals(other.zempresa))
			return false;
		return true;
	}

}
