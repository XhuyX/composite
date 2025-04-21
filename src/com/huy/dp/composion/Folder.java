package com.huy.dp.composion;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Folder implements ThanhPhan {
	String ten;
	List <ThanhPhan> lstfile ;
	@Override
	public long getTotalSize() {
		long total =0;
		for (ThanhPhan tp : this.lstfile ) {
			total += tp.getTotalSize();
		}
		return total;
	}
	
}
