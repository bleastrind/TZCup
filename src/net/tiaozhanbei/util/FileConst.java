/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tiaozhanbei.util;

/**
 *
 * @author buaatw
 */
public class FileConst {
    /* 采用位(length=5)子段进行文件访问权限控制
     * 由高位到低位依次为
     * 普通用户   企业用户   大赛评委  新闻编审  管理员
     */

		public static int MANAGER=1;
		public static int NEWSUSER=2;
		public static int JUDGER=4;
		public static int COMPANY=8;
		public static int COMMONUSER=16;
        public static void main(String[] sr){
        	

        }
}
