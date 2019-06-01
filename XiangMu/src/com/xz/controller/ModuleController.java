package com.xz.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xz.entity.Module;
import com.xz.entity.ModuleTree;
import com.xz.service.ModuleService;



@Controller
public class ModuleController {
     @Resource
	private ModuleService moduleServiceImp;
	@Resource
     private Module module;
	@RequestMapping(value="/ModuleManager")
 	private String ModuleManager() {

		return "ModuleManager";
	}
	
	
     @RequestMapping(value="/selectModule",method=RequestMethod.POST)
     @ResponseBody
     public List<ModuleTree> selectModule(){
    	 return moduleServiceImp.selectModules();
     }
     @RequestMapping(value="/insertMod",method=RequestMethod.POST)
     @ResponseBody
     public Integer insertMod(Module module) {
    	 return moduleServiceImp.insertMod(module);
     }
     @RequestMapping(value="/selectMbn",method=RequestMethod.POST)
     @ResponseBody
     public Integer selectMbn(Module module) {
    	 return moduleServiceImp.selectMbn(module);
     }
     @RequestMapping(value="/updateModu",method=RequestMethod.POST)
     @ResponseBody
     public  Map<String, Object> updateModu(Module module) {
    	 Integer i=moduleServiceImp.updateModu(module);
    	 Map<String, Object> map = new HashMap<String, Object>();
  		if (i == 1) {
  			map.put("msg", "�޸ĳɹ�");
  			map.put("success", true);
  		}
  		if (i == 2) {
  			map.put("msg", "�޸�ʧ��");
  			map.put("success", false);
  		}
  		if (i == 3) {
  			map.put("msg", "ͬһ���ڵ���ģ���������ظ��������");
  			map.put("success", false);
  		}
     	 return map;
     }
     @RequestMapping(value="/selectByid",method=RequestMethod.POST)
     @ResponseBody
     public Module selectByid(Integer m_id){
    	 Module adfs = moduleServiceImp.selectByid(m_id);
    	 return adfs;
     }
     @RequestMapping(value="/deleteMod",method=RequestMethod.POST)
     @ResponseBody
     public Map<String, Object> deleteMod(Integer m_id) {
    	 Integer i = moduleServiceImp.deleteMod(m_id);
    	 Map<String, Object> map = new HashMap<String, Object>();
 		if (i == 1) {
 			map.put("msg", "ɾ���ɹ�");
 			map.put("success", true);
 		}
 		if (i == 2) {
 			map.put("msg", "ɾ��ʧ��");
 			map.put("success", false);
 		}
 		if (i == 3) {
 			map.put("msg", "��ģ�����ڱ�Ӧ�ã�����ɾ��");
 			map.put("success", false);
 		}
    	 return map;
     }
}
