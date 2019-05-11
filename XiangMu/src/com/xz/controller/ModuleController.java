package com.xz.controller;



import java.util.List;

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
     public Integer updateModu(Module module) {
    	 return moduleServiceImp.updateModu(module);
     }
     @RequestMapping(value="/selectByid",method=RequestMethod.POST)
     @ResponseBody
     public Module selectByid(Integer m_id){
    	 String adfs = moduleServiceImp.selectByid(m_id);
    	 module.setMessage(adfs);
    	 return module;
     }
     @RequestMapping(value="/deleteMod",method=RequestMethod.POST)
     @ResponseBody
     public Integer deleteMod(Integer m_id) {
    	 return moduleServiceImp.deleteMod(m_id);
     }
}
