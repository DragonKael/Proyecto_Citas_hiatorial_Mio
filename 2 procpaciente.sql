set global log_bin_trust_function_creators = 1;
use bd_cita_medica;
--  listar
drop procedure if exists usp_listar_paciente;
-- drop procedure if exists usp_recuperar_paciente;
drop procedure if exists usp_insertar_paciente;
drop function if exists fn_generar_id_paciente;
drop procedure if exists usp_modificar_paciente;
drop procedure if exists usp_eliminar_paciente;
delimiter XD
	create procedure usp_listar_paciente(pbuscar varchar(50))
		begin
			select *
			from tpaciente
			where apaterno like concat('%',pbuscar,'%');
		end XD
	-- funcion generar id paciente
-- crear genero
	create function fn_generar_id_paciente()
				returns int
		begin
			set @id_paciente=(select count(*)from tpaciente);
				if(@id_paciente=0)then
					return 1;
				else
					begin
						set @id_paciente=(select max(id_paciente)from tpaciente)+1;
                        return @id_paciente;
                    end;
				end if;		
	end XD
    -- recuperar
    -- create procedure usp_recuperar_paciente(pemail varchar(255), 
-- 												pcontrasenia varchar(60))
--     begin
-- 			select *
-- 			from tpaciente
-- 			where email like pemail and contrasenia like pcontrasenia;
-- 		end XD
	-- insertar
	create procedure usp_insertar_paciente(pcod_personal varchar(50),
											pnombre varchar(50),
											papaterno varchar(50),
											pamaterno varchar(50),
											pgenero varchar(1),
											pdia_nace date,
											pemail varchar(100),
											pdireccion varchar(50),
											ptelefono varchar(15),
											pimagen text,
                                            pgrupo_sanguineo varchar(3),
											pcreado_en datetime)
		begin
			set @id_paciente=fn_generar_id_paciente();
			if exists(	select *
						from tpaciente
						where (id_paciente=@id_paciente))then
				begin
					set @mensaje='error el paciente existe';
					set @id_error=0;
				end;
			else
				if exists(	select *
						from tpaciente
						where (cod_personal=pcod_personal))then
				begin
					set @mensaje='error el codigo personal ya existe';
					set @id_error=0;
				end;
				else
					begin
						insert into tpaciente values(@id_paciente,
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
														pgrupo_sanguineo,
														true, 
														true,
														pcreado_en);
						set@mensaje='EXISTOOOOOOOO!!!!!!!!!!!!! LO INSERTASTE CORRECTAMENTE';
						set@id_error=0;
					end;
				end if;
			end if;
			select @mensaje,@id_error;
            select * from tpaciente;
		end XD 
-- modificar
	
    create procedure usp_modificar_paciente(id_paciente int,
											pcod_personal varchar(50),
											pnombre varchar(50),
											papaterno varchar(50),
											pamaterno varchar(50),
											pgenero varchar(1),
											pdia_nace date,
											pemail varchar(100),
											pdireccion varchar(50),
											ptelefono varchar(15),
											pimagen text,
											pgrupo_sanguieno varchar(3),
											pes_favorito boolean,
											pes_activo boolean,
											pcreado_en datetime)
		begin
			if not exists(	select *
						from tpaciente
						where (id_paciente=pid_paciente))then
				begin
					set @mensaje='error no existe el paciente';
					set @id_error=1;
				end;
			else
				if exists(	select *
						from tpaciente
						where (cod_personal=pcod_personal))then
				begin
					set @mensaje='error el codigo personal ya existe';
					set @id_error=1;
				end;
				else
					begin
						update tpaciente set	cod_personal=pcod_personal,
												nombre=pnombre,
												apaterno=papaterno,
												amaterno=pamaterno,
												genero=pgenero,
												dia_nace=pdia_nace,
												email=pemail,
												direccion=pdireccion,
												telefono=ptelefono,
												imagen=pimagen,
												grupo_sanguineo=pgrupo_sanguineo,
												es_favorito=pes_favorito,
												es_activo=pes_activo,
												creado=pcreado_en
							where id_paciente = pid_paciente;
						set@mensaje='EXISTOOOOOOOO!!!!!!!!!!!!! LO MODIFICASTE CORRECTAMENTE';
						set@id_error=0;
					end;
				end if;
			end if;
			select @mensaje,@id_error;
            select * from tpaciente;
		end XD 
-- call usp_modificar_paciente('defghijkabbc','sda','dsad','c','defghijk','e','f','g','h')
-- eliminar

	create procedure usp_eliminar_paciente(pid_paciente int)
		begin
			if exists (select * from tpaciente where id_paciente=pid_paciente)then
				if not exists(select * from thistoria where id_paciente=pid_paciente)then
						delete from tpaciente where id_paciente=pid_paciente;
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
					set @mensaje='no existe paciente';
					set @id_error=1;
				end;
			end if;
			select @mensaje,@id_error;		
		end XD
	call usp_insertar_paciente('trial',
								'nombre',
								'apellido paterno',
								'apellido amaterno',
								'',
								now(),
								'email',
								'direccion',
								'telefono',
								'',
								'',
								now());
	-- call usp_eliminar_paciente(1)