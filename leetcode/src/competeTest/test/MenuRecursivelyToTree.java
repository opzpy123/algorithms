package competeTest.test;

import java.util.ArrayList;
import java.util.List;


//从数据库中查找所有地址

//	@Select("select t.id as addressId,t.address_name as addressName,t.parent_id as parentId from t_equipment_address t")

//	public List<EquipmentAddressVo> getAllEquipmentAddress();

//工具类

class TreeUtil {
	// RecursiveEquipmentType
	public static List<EquipmentAddressVo> RecursiveAddress(List<EquipmentAddressVo> treeNodes){
		List<EquipmentAddressVo> trees = new ArrayList<EquipmentAddressVo>();
		for (EquipmentAddressVo treeNode : treeNodes) {
			if ("".equals(treeNode.getParentId()) || null==treeNode.getParentId() ) {
				trees.add(findAddressChildren(treeNode,treeNodes));
			}
		}
		return trees;
	}

	/**
	 * 递归查找地址子节点
	 * @param treeNodes
	 * @return
	 */
	public static EquipmentAddressVo findAddressChildren(EquipmentAddressVo treeNode,List<EquipmentAddressVo> treeNodes) {
		for (EquipmentAddressVo it : treeNodes) {
			if(treeNode.getAddressId().equals(it.getParentId())) {
				if (treeNode.getChildren() == null) {
					treeNode.setChildren(new ArrayList<EquipmentAddressVo>());
				}
				treeNode.getChildren().add(findAddressChildren(it,treeNodes));
			}
		}
		return treeNode;
	}

}

//vo实体类

class EquipmentAddressVo {


	/**
	 * 地址ID
	 */
//	@ApiModelProperty("地址ID")
	private String addressId;
	/**
	 * 地址名称
	 */
//	@ApiModelProperty("地址名称")
	private String addressName;

	/**
	 * 父级地址ID
	 */
//	@ApiModelProperty("父级地址ID")
	private String parentId;

	private List<EquipmentAddressVo> children;

	public List<EquipmentAddressVo> getChildren() {
		return children;
	}
	public void setChildren(List<EquipmentAddressVo> children) {
		this.children = children;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

}

//controller层  将数据库中的地址使用treeutil类进行递归封装
class MenuRecursivelyToTree {
	public static void main(String[] args) {
//		List<EquipmentAddressVo> list = equipmentAddressService.getAllEquipmentAddress();

//		ResultMsg  =new ResultMsg(ResultStatusCode.OK, TreeUtil.RecursiveAddress(list));
	}

}