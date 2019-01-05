package com.transport.beans.etm;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WaybillBeans {

	private Integer waybill_id;

	private Integer waybill_number;

	private String waybill_depot;
	private String waybill_vehicle;
	private Integer waybill_conductor;
	private Integer waybill_driver;
	private Integer waybill_sup_driver;
	private Date duty_date;
	private Integer duty_id;
	private Integer etim_reg_no;
	private String rel_version_id;
	private Integer waybill_type_id;
	private Integer schedule_trip;
	private Integer actual_trip;
	private Float schedule_km;
	private Float actual_km;
	private Date duty_gen_time;
	private Date cash_dep_time;
	private Integer waybill_collect_time;
	private Integer issue_clerk;
	private String cash_collect_clerk;
	private String waybill_collect_clerk;

}
