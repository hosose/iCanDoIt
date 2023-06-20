package org.kosta.myproject.test;

public class TestPagination2 {

	public static void main(String[] args) {				
		PaginationDemo p=new PaginationDemo(48,9);
		System.out.println("startRowNumber:"+p.getStartRowNumber());
		System.out.println("endRowNumber:"+p.getEndRowNumber());
		System.out.println("totalPage:"+p.getTotalPage());		
		System.out.println("totalPageGroup:"+p.getTotalPageGroup());	
		System.out.println("nowPageGroup:"+p.getNowPageGroup());
		System.out.println("startPageOfPageGroup:"+p.getStartPageOfPageGroup());
		System.out.println("endPageOfPageGroup:"+p.getEndPageOfPageGroup());
		System.out.println("isPreviousPageGroup:"+p.isPreviousPageGroup());
		System.out.println("isNextPageGroup:"+p.isNextPageGroup());
		p=new PaginationDemo(22,3);
		System.out.println("startRowNumber:"+p.getStartRowNumber());
		System.out.println("endRowNumber:"+p.getEndRowNumber());
		System.out.println("totalPage:"+p.getTotalPage());		
		System.out.println("totalPageGroup:"+p.getTotalPageGroup());	
		System.out.println("nowPageGroup:"+p.getNowPageGroup());
		System.out.println("startPageOfPageGroup:"+p.getStartPageOfPageGroup());
		System.out.println("endPageOfPageGroup:"+p.getEndPageOfPageGroup());
		System.out.println("isPreviousPageGroup:"+p.isPreviousPageGroup());
		System.out.println("isNextPageGroup:"+p.isNextPageGroup());
	}
}
