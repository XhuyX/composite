package com.huy.dp.composion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class File implements ThanhPhan {
	String ten;
	long size;
	@Override
	public long getTotalSize() {
		return this.size;
	}
		
}
