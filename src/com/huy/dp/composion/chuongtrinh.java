package com.huy.dp.composion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class chuongtrinh {
	public static void inThanhPhan(ThanhPhan tp, String prefix) {
		if (tp instanceof File) {
			File f = (File) tp;
			System.out.println(prefix +"|_"+ f.getTen() + " " + f.getSize());
		}
		else {
			Folder f = (Folder) tp;
			System.out.println(prefix  +f.getTen() );
			for (ThanhPhan x: f.getLstfile()) {
				inThanhPhan(x ," " + prefix );
			}
		}
	}
	public static ThanhPhan BuildthanhPhan(int id, Map<Integer, RowData> raw, Map <Integer, ArrayList<Integer>> parentmap) {
			RowData rd = raw.get(id);
			if (rd.getSize()!=-1) {
				return new File(rd.getTen(),rd.getSize());
			}
			else {
				Folder fd = new Folder();
				fd.setTen(rd.getTen());
				List<ThanhPhan> lsttp = new ArrayList<>();
				List <Integer> tp = parentmap.getOrDefault(rd.getId(), new ArrayList());
				for (int child : tp) {
					ThanhPhan x = BuildthanhPhan(child,raw,parentmap);
					lsttp.add(x);
				}
				fd.setLstfile(lsttp);
				return fd;
			}
		}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection cnn= KetNoiGetter.getInstance().getCnn();
		String sql = "Select * from ThanhPhan";
		Statement sttm = cnn.createStatement();
		ResultSet rs = sttm.executeQuery(sql);
		
		Map <Integer , RowData> raw = new HashMap<>(); // chứa từng dòng data
		
		Map <Integer ,ArrayList<Integer>> parentMap = new HashMap<>();
		
		while (rs.next()) {
			// đọc tất cả - sau đó đọc các dòng có parent id = -1
			// sau đó là đọc các dòng có id tương tự mà có parent id =-1
			int id = rs.getInt("Id");
			String ten = rs.getString("Ten");
			int parentId = rs.getInt("ParentId");
			Long size = rs.getLong("Size");
			RowData rd= new RowData(id,parentId,ten,size); 
			raw.put(id, rd);
			parentMap.computeIfAbsent(parentId, k -> new ArrayList<>()).add(id);
		} 
		List<ThanhPhan> ltp = new ArrayList<>();
		List<Integer> rootid = parentMap.get(-1);
		for (int id : rootid) {
			ThanhPhan tp = BuildthanhPhan(id, raw,parentMap);
			ltp.add(tp);
		}
		for (ThanhPhan tp: ltp) {
			inThanhPhan(tp,"");
		}
	}
}