package com.jsoft.pos.view.model;

import com.jsoft.pos.domain.Counter;
import com.jsoft.pos.service.CounterService;
import com.jsoft.pos.util.AlertUtil;
import com.jsoft.pos.util.RetrofitSingleton;
import com.jsoft.pos.util.ServerStatus;

public class CountersViewModel extends SinglePageViewModel<Counter> {
	
	private CounterService service;
	
	public CountersViewModel() {
		service = RetrofitSingleton.getInstance().create(CounterService.class);
	}

	@Override
	public void load() {
		if (ServerStatus.isReachable()) {
			loading.set(true);
			service.findAll().enqueue(listCallBack());
		} else {
			AlertUtil.queueToast(ServerStatus.CONNECTION_ERROR);
		}
	}
	
	public void delete(Counter counter) {
		counter.setDeleted(true);
		save(counter);
	}
	
	public void save(Counter counter) {
		if (ServerStatus.isReachable()) {
			service.save(counter).enqueue(saveCallBack());
			
		} else {
			AlertUtil.queueToast(ServerStatus.CONNECTION_ERROR);
		}
		
	}
	
}
