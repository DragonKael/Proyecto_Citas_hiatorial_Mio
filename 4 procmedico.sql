set global log_bin_trust_function_creators = 1;
use bd_cita_medica;
--  listar
drop procedure if exists usp_listar_medico;
-- drop procedure if exists usp_recuperar_medico;
drop procedure if exists usp_insertar_medico;
drop function if exists fn_generar_id_medico;
drop procedure if exists usp_modificar_medico;
drop procedure if exists usp_eliminar_medico;
delimiter XD
	create procedure usp_listar_medico(pbuscar varchar(50))
		begin
			select *
			from tmedico
			where apaterno like concat('%',pbuscar,'%');
		end XD
	-- funcion generar id medico
-- crear genero
	create function fn_generar_id_medico()
				returns int
		begin
			set @id_medico=(select count(*)from tmedico);
				if(@id_medico=0)then
					return 1;
				else
					begin
						set @id_medico=(select max(id_medico)from tmedico)+1;
                        return @id_medico;
                    end;
				end if;		
	end XD
    -- recuperar
    -- create procedure usp_recuperar_medico(pemail varchar(255), 
-- 												pcontrasenia varchar(60))
--     begin
-- 			select *
-- 			from tmedico
-- 			where email like pemail and contrasenia like pcontrasenia;
-- 		end XD
	-- insertar
	create procedure usp_insertar_medico(pcod_personal varchar(50),
											pnombre varchar(50),
											papaterno varchar(50),
											pamaterno varchar(50),
											pgenero varchar(1),
											pdia_nace date,
											pemail varchar(255),
											pdireccion varchar(255),
											ptelefono varchar(255),
											pimagen varchar(255),
											pcreado_en datetime,
											pid_especialidad int)
		begin
			set @id_medico=fn_generar_id_medico();
			if exists(	select *
						from tmedico
						where (id_medico=@id_medico))then
				begin
					set @mensaje='error';
					set @id_error=0;
				end;
			else
				if exists(	select *
						from tmedico
						where (cod_personal=pcod_personal))then
				begin
					set @mensaje='error ya existe el codigo';
					set @id_error=0;
				end;
				else
					begin
						insert into tmedico values(@id_medico,
													pcod_personal,
													pnombre,
													papaterno,
													pamaterno,
													pgenero,
													pdia_nace,
													pemail,
													pdireccion,
													ptelefono,
													pimagen,
													true,
													pcreado_en,
													pid_especialidad);
						set@mensaje='EXISTOOOOOOOO!!!!!!!!!!!!! LO INSERTASTE CORRECTAMENTE';
						set@id_error=0;
					end;
				end if;
			end if;
			select @mensaje,@id_error;
            select * from tmedico;
		end XD 
-- modificar
	
    create procedure usp_modificar_medico(pid_medico int,
											pcod_personal varchar(50),
											pnombre varchar(50),
											papaterno varchar(50),
											pamaterno varchar(50),
											pgenero varchar(1),
											pdia_nace date,
											pemail varchar(255),
											pdireccion varchar(255),
											ptelefono varchar(255),
											pimagen varchar(255),
											pes_activo boolean,
											pcreado_en datetime,
											pid_especialidad int)
		begin
			if not exists(	select *
						from tmedico
						where (id_medico=pid_medico))then
				begin
					set @mensaje='error no existe';
					set @id_error=0;
				end;
			else
				if exists(	select *
						from tmedico
						where (cod_personal=pcod_personal))then
				begin
					set @mensaje='error ya existe el codigo personal';
					set @id_error=0;
				end;
				else
					begin
						update tmedico set	cod_personal=pcod_personal,
												nombre=pnombre,
												apaterno=papaterno,
												amaterno=pamaterno,
												genero=pgenero,
												dia_nace=pdia_nace,
												email=pemail,
												direccion=pdireccion,
												telefono=ptelefono,
												imagen=pimagen,
												es_activo=pes_activo,
												creado_en=pcreado_en,
												id_especialidad=pid_especialidad
												
							where id_medico = pid_medico;
						set@mensaje='EXISTOOOOOOOO!!!!!!!!!!!!! LO MODIFICASTE CORRECTAMENTE';
						set@id_error=0;
					end;
				end if;
			end if;
			select @mensaje,@id_error;
            select * from tmedico;
		end XD 
-- call usp_modificar_medico('defghijkabbc','sda','dsad','c','defghijk','e','f','g','h')
-- eliminar

	create procedure usp_eliminar_medico(pid_medico int)
		begin
			if exists (select * from tmedico where id_medico=pid_medico)then
				if not exists(select * from treserva where id_medico=pid_medico)then
						delete from tmedico where id_medico=pid_medico;
					begin
						set @mensaje='existo';
						set @id_error=0;
					end;
				else
					begin
						set @mensaje='error se encuentra en la tabla reservacion';
						set @id_error=1;
					end;
				end if;
			else
				begin
					set @mensaje='no existe medico';
					set @id_error=1;
				end;
			end if;
			select @mensaje,@id_error;		
		end XD
        call usp_eliminar_medico(1);
        call usp_insertar_medico('trial',
									'nombre',
									'apaterno',
									'amaterno ',
									'',
									now(),
									'email',
									'direccion',
									'telefono',
									'',
									now(),
									1)