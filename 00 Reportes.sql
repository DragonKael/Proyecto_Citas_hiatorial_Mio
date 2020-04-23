use bd_cita_medica;
drop procedure if exists usp_listar_citas_x_dia;
drop procedure if exists usp_listar_citas_x_rango;
drop procedure if exists usp_listar_atenciones_x_rango;
drop procedure if exists usp_medicos_x_especialidad;
-- citas por dia
delimiter XD
	create procedure usp_listar_citas_x_dia()
	begin 
		select r.creado_en, concat(p.nombre," ", p.apaterno," ",p.amaterno)as Paciente, p.telefono, r.titulo
		from treserva r inner join thistoria h on r.id_historia = h.id_historia 
        inner join tpaciente p on h.id_paciente=p.id_paciente
		where fecha_prestamo = curdate();
end XD


-- citas entre 2 fechas
	create procedure usp_listar_citas_x_rango (pfecha1 date, pfecha2 date)
	begin
		select r.fecha_de_cita, concat(p.nombre," ", p.apaterno," ",p.amaterno)as Paciente, p.telefono, r.titulo
		from treserva r inner join thistoria h on r.id_historia = h.id_historia 
        inner join tpaciente p on h.id_paciente=p.id_paciente
		where r.creado_en between pfecha1 and pfecha2;
end XD

-- atenciones entre 2 fechas
create procedure usp_listar_atenciones_x_rango (pfecha1 date, pfecha2 date)
	begin
		select r.fecha_de_cita, concat(p.nombre," ", p.apaterno," ",p.amaterno)as Paciente, p.telefono, r.titulo
		from treserva r inner join thistoria h on r.id_historia = h.id_historia 
        inner join tpaciente p on h.id_paciente=p.id_paciente
		where r.fecha_de_cita between pfecha1 and pfecha2;
end XD

-- medico especialidad 

	create procedure usp_medicos_x_especialidad()
	begin
		select c.nombre, concat(m.nombre," ", m.apaterno," ",m.amaterno)as Medico
		from tmedico m inner join tespecialidad e on m.id_especialidad = e.id_especialidad;
end XD



