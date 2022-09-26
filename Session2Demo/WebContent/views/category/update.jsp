<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>
      </form>
      		<form method="POST" role="form">
        <input type="hidden" name="action" value="add" />
        <input type="hidden" name="id" value="${cat.id}" />
        <input type="hidden" name="parentId" value="0" />
        <legend>Thêm danh mục</legend>
        <div class="form-group">
          <label for="">Name</label>
          <input type="text" class="form-control" name="name" placeholder="Nhap Name ..." value="${cat.name}">
        </div>
        
        <div class="form-group">
        	<input type="radio" id="show" name="status" value="1">
			<label for="show">Hien thi</label><br>
			<input type="radio" id="hide" name="status" value="2">
  			<label for="hide">An</label><br>	
        </div>
        
      
        
      
        <button class="btn btn-primary">Cap nhat</button>
      </form>
<%@include file="../layout/footer.jsp"%>