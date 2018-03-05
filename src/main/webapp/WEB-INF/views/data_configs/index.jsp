<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table>
	<thead>
		<tr>
			<th width="20%"> 名称</th>
		    <th width="10%"> 代码</th>
		    <th width="10%"> 状态</th>
		    <th width="40%"> 创建时间</th>
		    <th width="20%"> 操作</th>
		</tr>
	</thead>
	<c:if test="${data_configs.size()<=0}"> 
		<tr>
		    <td colspan="5" align="center">暂无数据</td>
		</tr>
	</c:if>
	<c:if test="${data_configs.size()>0}"> 
		<c:forEach var="config" items="${data_configs}">
			<tr>
			    <td align="center">${config.typeName }</td>
			    <td align="center">${config.typeCode }</td>
			    <td align="center">${config.status }</td>
			    <td align="center">${config.createdAt }</td>
			    <td align="center">
			    	<a href="company/${config.id}/edit">修改</a> | 
			    	<a href="company/${config.id}" class="a_delete">删除</a> | 
			    	<a href="">查看</a> | 
			    </td>
			</tr>
		</c:forEach>
	</c:if>
</table>
