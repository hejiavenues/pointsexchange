﻿//vue ，bookstrap 使用
const zs_messages = {
    zh: {
    	zs:"管理后台",
    	homepage:"系统主页",
    	operation:"页签操作",
    	refresh:"刷新当前",
    	close:"关闭当前",
    	closeAll:"全部关闭",
    	closeAllE:"除此之外全部关闭",
    	changeLanguage:"切换语言",
    	changePa:"修改密码",
    	safeExit:"安全退出",
    	account : "用户账号", 
    	oldP:"原密码", 
		newP:"新密码",
    },
    en: {
    	zs:"ZS",
    	homepage: 'homepage',
    	operation:"operation",
    	refresh:"refresh",
    	close:"close",
    	closeAll:"close all",
    	closeAllE:"close except now",
    	changeLanguage:"change language",
     	changePa:"change password",
    	safeExit:"safe exit",
    	account : "account", 
		oldP:"old password", 
		newP:"new password",
		tabs:{
			 "电核审批" : "Approval",
		     "审批记录" : "ApprovalRecord",
		     "人工审批": "ArtificialApproval",
			 "审批管理": "ApprovalManagement",
			 "审批队列" : "Approval Queue", 
			 "审批记录（管理员）" : "ApprovalRecord (admin)",
			 "风控管理" : "RiskManagement",
			 "风控规则":"RiskManagementRules",
			 "渠道风控配置":"ChannelRiskManagement",
			 "报文管理":"MessageManagement",
			 "黑白名单":"BlackAndWhitList",
			 "查询管理":"QueryManagement",
			 "客户借款查询":"CustomerLoanLnquiry",
			 "风控决策结果查询":"RiskDecisionQuery",
			 "综合查询":"ComprehensiveQuery",
			 "支付查询":"PaymentEnquiry",
			 "业务异常进件报文查询":"BizException",
			 "渠道管理":"ChannelManagement",
			 "渠道信息":"ChannelInformation",
			 "渠道组织机构":"ChannelOrganization",
			 "通用设置":"GeneralSettings",
			 "config配置":"configuration",
			 "子渠道配置":"SubchannelAllocation",
			 "产品配置":"ProductSetup",
			 "产品充值":"ProductRecharge",
			 "渠道订单":"ChannelOrder",
			 "渠道充值":"ChannelRecharge",
			 "统计报表":"StatisticalReportForms",
			 "各环节统计":"Statistics",
			 "各环节详情":"details",
			 "各环节转化":"conversion",
			 "各渠道成本":"cost",
			 "测试工具":"TestTools",
			 "接口测试落库":"InterfaceTestDeposit",
			 "数据推送":"DataPush",
			 "接口测试":"InterfaceTest",
			 "组织机构":"Organization",
			 "机构管理":"Organizational",
			 "角色管理":"RoleManagement",
			 "用户管理":"UserManagement",
			 "系统管理":"SystemManagement",
			 "行政区域":"Administration",
			 "系统菜单":"system menus",
			 "通用字典":"General dictionary",
			 "系统日志":"system log",
			 "定时任务":"Timing task",
			 "敏捷开发":"agile development",
			 "系统监控":"System monitoring",
		}
			 
    },
    id: {
    	zs:"Dengan menghitung",
    	homepage:"Sistem homepage",
    	operation:"operasi",
    	refresh:"Refresh saat ini",
    	close:"Menutup saat ini",
    	closeAll:"Tutup semuanya!",
    	closeAllE:"Selain itu semua ditutup",
    	changeLanguage:"Ganti bahasa",
    	changePa:"Mengganti kata sandinya",
    	safeExit:"Di luar aman",
    	account : "Akun pengguna", 
    	oldP:"Kode", 
		newP:"Kata sandi yang baru",

		tabs:{
			 "电核审批" : "Listrik persetujuan nuklir",
		     "审批记录" : "Catatan persetujuan",
		     "人工审批": "Persetujuan buatan",
			 "审批管理": "Manajemen persetujuan",
			 "审批队列" : "Persetujuan antrian", 
			 "审批记录（管理员）" : "Catatan persetujuan (administrator)",
			 "风控管理" : "Kontrol risiko",
			 "风控规则":"Peraturan pengendalian resiko",
			 "渠道风控配置":"Konfigurasi pengendalian risiko saluran",
			 "报文管理":"Sweeping para pimpinan",
			 "黑白名单":"Daftar hitam putih",
			 "查询管理":"Manajemen pencarian",
			 "客户借款查询":"Pertanyaan pinjaman pelanggan",
			 "风控决策结果查询":"Keputusan keputusan kontrol resiko dipertanyakan",
			 "综合查询":"Hubungi terintegrasi",
			 "支付查询":"Hubungi membayar",
			 "业务异常进件报文查询":"Pertanyaan pesan pengirim anomali",
			 "渠道管理":"Mengatur jalur",
			 "渠道信息":"Saluran informasi",
			 "渠道组织机构":"Jaringan jaringan",
			 "通用设置":"Pengaturan g. I.",
			 "config配置":"Konfigurasi config",
			 "子渠道配置":"Konfigurasi subchannel",
			 "产品配置":"Konfigurasi produk",
			 "产品充值":"Produk uangnya",
			 "渠道订单":"Perintah jalur",
			 "渠道充值":"Akan mengambil jalur",
			 "统计报表":"Laporan statistik",
			 "各环节统计":"Semuanya dihitung",
			 "各环节详情":"Semua detail",
			 "各环节转化":"Transformasi",
			 "各渠道成本":"Biaya setiap saluran",
			 "测试工具":"Utilitas pengujian",
			 "接口测试落库":"Interface test drop bank",
			 "数据推送":'Data tekan "kirim."',
			 "接口测试":"Tes antarmuka",
			 "组织机构":"Mentoring organization",
			 "机构管理":"Badan pimpinan",
			 "角色管理":"Peran mengelola",
			 "用户管理":"Pengguna mengelola",
			 "系统管理":"Sistem manajemen",
			 "行政区域":"Daerah administratif",
			 "系统菜单":"Menu sistem",
			 "通用字典":"Kamus sehari-hari",
			 "系统日志":"Catatan sistem",
			 "定时任务":"Misi waktu",
			 "敏捷开发":"agile",
			 "系统监控":"Monitor sistemname",
		}
    }
}


