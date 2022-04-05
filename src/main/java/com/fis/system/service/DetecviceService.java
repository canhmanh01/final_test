package com.fis.system.service;

import com.fis.system.entity.Detecvice;

public interface DetecviceService {

	String adddetecvice(Detecvice detecvice);

	String updatedetecvice(Detecvice detecvice);

	void deletedetecvice(Long detecviceId);

	Detecvice findByid(Long detecviceId);

}
