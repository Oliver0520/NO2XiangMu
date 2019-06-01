var mokuai = null;
	$(function() {
		myTree();
	});

	function myTree() {
		$("#menuTree").tree({
			url : "selectModule",
			method : "post",
			lines : true,
			onContextMenu : function(e, node) {
				e.preventDefault();

				$("#menuTree").tree('select', node.target);
				$("#mm").menu("show", {
					left : e.pageX,
					top : e.pageY
				});
			}
		});
	}
	
	function addInfo() {
		var nodes = $("#menuTree").tree("getSelected");
		if (nodes.text != "") {
			$("#pname").text(nodes.text);
			$("#add_window").window("open");
		} else {
			alert("请选择父节点");
		}
	}
	function submitaddUserForm() {
		var nodes = $("#menuTree").tree('getSelected');
		var flag = $("#adduserForm").form("validate");
		var moduleName = $("#name1").val();
		var weight = $("#weight1").val();
		var path = $("#url1").val();
		if (flag) {
			$.post("selectMbn", {
				m_name : moduleName,
				m_parentId : nodes.id
			}, function(res) {
				if (res > 0) {
					$.messager.alert('提示', '模块名称已被占用，请更换！！！');
				} else {
					$.post("insertMod", {
						m_name : moduleName,
						m_parentId : nodes.id,
						m_path : path,
						m_weight : weight
					}, function(res) {
						if (res > 0) {
							$.messager.alert("提示", "新增成功");
							$("#add_window").window("close");
							$('#adduserForm').form('clear');
							myTree();
						} else {
							$.messager.alert("提示", "新增失败");
						}
					}, "json");
				}
			}, "json");

		}
	}
	function clearModuleForm() {
		$('#adduserForm').form('clear');
		$("#add_window").window("close");
	}

	function updateInfo() {
		var nodes = $('#menuTree').tree('getSelected');
		$.post("selectByid", {
			m_id : nodes.id,
		}, function(res) {
			/* alert(res.message);
			var sss = res.message ; */
			mokuai = null;
			mokuai = res;
			$('#updateuserForm').form('load', mokuai);
			$('#update_window').window('open');
		}, "json");

	}

	
	function uclearModuleForm() {
		$("#update_window").window("close");
	}
	function Info() {
		var nodes = $('#menuTree').tree('getSelected');
		$.messager.confirm('确认', '您确认想要删除记录吗？', function(r) {
			if (r) {
				$.post("deleteMod", {
					m_id : nodes.id
				}, function(res) {
					if (res.success) {
						$.messager.alert("提示", res.msg);
						myTree();
					} else {
						$.messager.alert("提示", res.msg);
					}
				}, "json");
			}
		});
	}